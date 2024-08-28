package com.sc.scbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.sc.scbackend.dao")
public class ScBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScBackendApplication.class, args);
    }
}
