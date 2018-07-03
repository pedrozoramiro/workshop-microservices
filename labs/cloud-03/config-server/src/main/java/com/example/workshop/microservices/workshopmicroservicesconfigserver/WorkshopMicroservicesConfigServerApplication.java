package com.example.workshop.microservices.workshopmicroservicesconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class WorkshopMicroservicesConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopMicroservicesConfigServerApplication.class, args);
	}
}
