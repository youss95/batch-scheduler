package com.ksy.batchspring;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchSpringApplication.class, args);
    }

}
