package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class springboot2jdbcwithh2application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    studentjdbcrepository repository;

    public static void main(String[] args) {
        SpringApplication.run(springboot2jdbcwithh2application.class, args);
    }

    @Override
    public void run(String...args) throws Exception {

        logger.info("student id 10001 -> {}", repository.findbyid(10001));
    }
    
}