package com.example.mystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.mystore.controllers")
public class MystoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MystoreApplication.class, args);
	}
}
