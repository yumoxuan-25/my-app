package com.yumoxuan.myapp.core.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DistributedLock {
    /**
     * 锁的名称
     * @return
     */
    String name() default "";
    /**
     * 锁的参数key
     * @return
     */
    String[] key() default {};

    /**
     * 锁过期时间
     * @return
     */
    int expireTime() default 30;

    /**
     * 锁过期时间单位
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 等待获取锁超时时间
     * @return
     */
    int waitTime() default 10;
}
