package com.imona.javaassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@EnableJpaRepositories(basePackages = "com.imona.javaassignment.repository")
@ComponentScan(basePackages = "com.imona.javaassignment.service")
@SpringBootApplication
public class JavaassignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaassignmentApplication.class, args);
    }

}
