package com.co.fashion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FashionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FashionApplication.class, args);
	}

}
