package com.example.henrymeds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan({"com.example.henrymeds.components"})
public class HenryMedsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HenryMedsApplication.class, args);
	}

}
