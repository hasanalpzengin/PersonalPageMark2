package com.hasanalpzengin.personalpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class PersonalpageApplication {
	public static void main(String[] args) {
		SpringApplication.run(PersonalpageApplication.class, args);
	}

}
