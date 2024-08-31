package com.sc.scbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScans({
        @MapperScan("com.sc.scbackend.SCEmployee.dao"),
        @MapperScan("com.sc.scbackend.SCPending.dao"),
        @MapperScan("com.sc.scbackend.SCResident.dao"),
        @MapperScan("com.sc.scbackend.SCInfrastructure.dao")
})
public class ScBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScBackendApplication.class, args);
    }
}
