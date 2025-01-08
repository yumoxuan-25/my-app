package com.yumoxuan.core.aspect;


import com.yumoxuan.core.aspect.annotation.DistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Slf4j
@Aspect
@Component
public class DistributedLockAspect {
    @Resource
    public RedissonClient redissonClient;

    @Pointcut("@annotation(com.yumoxuan.core.aspect.annotation.DistributedLock)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        DistributedLock annotation = method.getAnnotation(DistributedLock.class);
        String name = annotation.name();
        String key = name;
        String[] keys = annotation.key();
        int expireTime = annotation.expireTime();
        TimeUnit timeUnit = annotation.timeUnit();
        int waitTime = annotation.waitTime();

        Object[] args = point.getArgs(); // 参数值
        String[] paramNames = signature.getParameterNames(); // 参数名
        for (int i = 0; i < args.length; i++) {
            String paramName = paramNames[i];
            for (int j = 0; j < keys.length; j++) {
                if (paramName.equals(keys[j])) {
                    key = key + ":" + args[i];
                }
            }
        }
        RLock lock = redissonClient.getLock(key);
        boolean res = false;
        Object obj = null;
        try {
            if (waitTime == -1) {
                res = true;
                lock.lock(expireTime, timeUnit);
            } else {
                res = lock.tryLock(waitTime, expireTime, timeUnit);
            }
            if (res) {
                obj = point.proceed();
            } else {
                log.error("分布式锁获取异常");
            }
        } finally {
            //释放锁
            if (res) {
                lock.unlock();
            }
        }
        return obj;
    }
}
