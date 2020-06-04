package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.qf.dao")
public class CarsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarsysApplication.class, args);
    }

}
