package com.eduassistant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@MapperScan("com.eduassistant.mapper")
public class eduassistantSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(eduassistantSystemApplication.class, args);
    }

}

