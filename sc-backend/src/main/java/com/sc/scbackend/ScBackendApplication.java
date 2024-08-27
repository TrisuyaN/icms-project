package com.sc.scbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.sc.scbackend.dao")
public class ScBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScBackendApplication.class, args);
    }
}
