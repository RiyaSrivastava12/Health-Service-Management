package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthServiceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthServiceManagementApplication.class, args);
		System.out.println("Connected to databse");
	}

}
