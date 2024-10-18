package com.yumoxuan.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.yumoxuan.*.mapper")
@Configuration
public class MybatisPlusConfig {

}
