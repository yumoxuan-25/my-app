package com.yumoxuan.myapp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.yumoxuan.myapp.*.mapper")
@Configuration
public class MybatisPlusConfig {

}
