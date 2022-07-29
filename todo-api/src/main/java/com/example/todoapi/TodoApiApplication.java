package com.example.todoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TodoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApiApplication.class, args);
    }

}
