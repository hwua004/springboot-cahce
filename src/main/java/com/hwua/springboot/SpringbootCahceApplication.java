package com.hwua.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.hwua.springboot.dao")
@EnableCaching
public class SpringbootCahceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCahceApplication.class, args);
    }
}
