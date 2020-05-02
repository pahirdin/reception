package com.phd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value="com.phd.reception.mapper")
public class ReceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceptionApplication.class, args);
    }

}
