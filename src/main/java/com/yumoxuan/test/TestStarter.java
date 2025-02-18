package com.yumoxuan.test;

import lombok.Data;

/**
 * @ClassName: TestStarter
 * @Author: zengjingchao
 * @Date: 2025/2/18 17:06
 * @Description:
 **/
@Data
public class TestStarter {
	private String name;
	public TestStarter(){
		this.name="i'm default name";
	}

	public void test() {
		System.out.println("自动装配的方法执行了" + name);
	}
}
