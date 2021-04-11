package com.example.campusinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CampusinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusinfoApplication.class, args);
    }

}
