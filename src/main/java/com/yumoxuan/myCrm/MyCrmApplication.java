package com.yumoxuan.myCrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yumoxuan.myCrm.*.mapper")
@SpringBootApplication
public class MyCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCrmApplication.class, args);
    }

}
