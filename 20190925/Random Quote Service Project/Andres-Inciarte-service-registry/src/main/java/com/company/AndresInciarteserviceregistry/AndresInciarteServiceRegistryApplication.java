package com.company.AndresInciarteserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AndresInciarteServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndresInciarteServiceRegistryApplication.class, args);
	}

}
