package com.example.designpatterns;

import com.example.designpatterns.builder.BuilderPattern;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DesignPatternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsApplication.class, args);
    }
    @Bean
    CommandLineRunner run(BuilderPattern builderPattern) {
        return args -> {
            builderPattern.example0();
        };
    }
}
