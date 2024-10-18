package com.yumoxuan.myapp.test;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: NotifyTest
 * @Author: zengjingchao
 * @Date: 2024/10/8 11:00
 * @Description:
 **/
public class NotifyTest {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getId() + "条件1开始" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					System.out.println(Thread.currentThread().getId() + "条件1获取到锁" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					condition1.await();
					System.out.println(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println(Thread.currentThread().getId() + "条件1结束" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getId() + "条件2开始" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

					System.out.println(Thread.currentThread().getId() + "条件2获取到锁" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					condition2.await();
					System.out.println(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println(Thread.currentThread().getId() + "条件2结束" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getId() + "开始" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					//先睡一秒，让上面两个线程先后获取锁并阻塞
					Thread.sleep(1000);

					System.out.println(Thread.currentThread().getId() + "获取到锁" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					condition2.signal();
					System.out.println(3);
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println(Thread.currentThread().getId() + "结束" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

				}
			}
		}).start();

	}
}
