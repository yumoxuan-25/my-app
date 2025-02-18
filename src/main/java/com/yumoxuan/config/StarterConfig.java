package com.yumoxuan.config;

import com.yumoxuan.test.TestStarter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: StarterConfig
 * @Author: zengjingchao
 * @Date: 2025/2/18 17:10
 * @Description:
 **/
@Configuration
public class StarterConfig {
	@Bean
	public TestStarter testStarter(){
		return new TestStarter();
	}
}
