package com.project.FoodDeliveryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@RestController
public class FoodDeliveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryServiceApplication.class, args);	}
	
	@GetMapping("/hello")
	public String helo() {
		return "Helloo";
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").
				exposedHeaders("*").allowedHeaders("*");
			}
		};
	}

}
