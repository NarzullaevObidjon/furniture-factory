package com.company.furniturefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.company")
public class FurnitureFactoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(FurnitureFactoryApplication.class, args);
    }

}
