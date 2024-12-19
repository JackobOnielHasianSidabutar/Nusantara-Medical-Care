package com.example.nmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.nmc")
public class NmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(NmcApplication.class, args);
	}

}
