package com.yumoxuan.user.service.impl;

import com.yumoxuan.user.entity.MyAppUser;
import com.yumoxuan.user.mapper.MyAppUserMapper;
import com.yumoxuan.user.service.IMyAppUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Description: my_app_user
 * @Author: jeecg-boot
 * @Date:   2024-04-10
 * @Version: V1.0
 */
@Slf4j
@Service
public class MyAppUserServiceImpl extends ServiceImpl<MyAppUserMapper, MyAppUser> implements IMyAppUserService {
	@Autowired
	private IMyAppUserService myAppUserService;
	@Resource
	private RedisTemplate redisTemplate;
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void testA() {
		try {
//			MyAppUser myAppUser = new MyAppUser();
//			myAppUser.setUserNo("A" + UUID.randomUUID());
//			myAppUser.setNickName("A事务");
//			this.save(myAppUser);
//			myAppUserService.testB();
//			int a=10/0;
			redisTemplate.opsForValue().set("1",1,60);
			List<MyAppUser> myAppUsers = this.baseMapper.queryList();
			Thread.sleep(10000);
			System.out.println("A执行完毕");
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error("A事务回滚了",e);
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void testB() {
		try {
//			MyAppUser myAppUser = new MyAppUser();
//			myAppUser.setUserNo("B" + UUID.randomUUID());
//			myAppUser.setNickName("B事务");
//			this.save(myAppUser);
			List<MyAppUser> myAppUsers = this.baseMapper.queryList();
//			Thread.sleep(3000);
			System.out.println("B执行完毕");
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error("B事务回滚了",e);
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void testC() {

	}
}
