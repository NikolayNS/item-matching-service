package com.dmitrenko.privateapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dmitrenko.transfer.api", "com.dmitrenko.database"})
public class PrivateApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrivateApiApplication.class, args);
	}
}
