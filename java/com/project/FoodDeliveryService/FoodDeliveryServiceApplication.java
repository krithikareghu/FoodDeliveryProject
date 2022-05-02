package com.project.FoodDeliveryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class FoodDeliveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryServiceApplication.class, args);	}

}
