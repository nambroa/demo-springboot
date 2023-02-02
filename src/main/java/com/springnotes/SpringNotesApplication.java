package com.springnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// identifies which classes should be used by a JPA persistence context.
@EntityScan("com.springnotes.model")
// create repository classes from Spring Data interfaces.
@EnableJpaRepositories("com.springnotes.repository")
public class SpringNotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNotesApplication.class, args);
    }

}
