package com.codecool.thecodecooltimesbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TheCodeCoolTimesBackendApp {

    public static void main(String[] args) {
        SpringApplication.run(TheCodeCoolTimesBackendApp.class, args);
    }

}
