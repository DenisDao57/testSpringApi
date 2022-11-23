package com.example.nbaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"nba","player"})
public class NbaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbaApiApplication.class, args);
    }

}
