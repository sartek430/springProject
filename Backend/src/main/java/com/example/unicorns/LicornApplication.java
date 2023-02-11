package com.example.unicorns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EnableJpaRepositories(basePackages = "com.example.unicorns")
@EntityScan(basePackages = "com.example.unicorns")
@SpringBootApplication
public class LicornApplication {
    public static void main(String[] args) {
        SpringApplication.run(LicornApplication.class, args);
    }

}
