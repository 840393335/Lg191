package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.cssl.dao")
@EnableCaching
@SpringBootApplication
public  class ReidsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReidsApplication.class, args);
    }

}
