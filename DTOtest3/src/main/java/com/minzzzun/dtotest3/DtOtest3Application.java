package com.minzzzun.dtotest3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class DtOtest3Application {

    public static void main(String[] args) {
        SpringApplication.run(DtOtest3Application.class, args);
    }

}
