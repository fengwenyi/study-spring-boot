package com.fengwenyi.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Erwin Feng
 * @since 2020-11-20
 */
//@SpringBootApplication
    @Configuration
    @EnableAutoConfiguration
    @ComponentScan
public class StudySpringBootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudySpringBootDemoApplication.class);
    }
}
