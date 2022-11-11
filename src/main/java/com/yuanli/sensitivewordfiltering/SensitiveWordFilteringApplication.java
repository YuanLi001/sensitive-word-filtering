package com.yuanli.sensitivewordfiltering;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = {"com.yuanli.sensitivewordfiltering.dao"})
@SpringBootApplication
public class SensitiveWordFilteringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensitiveWordFilteringApplication.class, args);
    }

}
