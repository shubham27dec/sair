package com.sair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SairApplication {
    public static void main(String[] args) {
        SpringApplication.run(SairApplication.class, args);
    }
}
