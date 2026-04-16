package com.ore.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * ORE REST API Application Entry Point
 */
@SpringBootApplication
@EnableAsync
public class OreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OreApiApplication.class, args);
    }
}
