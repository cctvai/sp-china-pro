package com.example.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PersonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class, args);
    }

}
