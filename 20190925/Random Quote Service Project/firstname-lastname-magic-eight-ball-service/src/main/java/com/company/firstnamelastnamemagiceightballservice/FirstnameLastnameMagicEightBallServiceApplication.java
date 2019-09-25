package com.company.firstnamelastnamemagiceightballservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FirstnameLastnameMagicEightBallServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstnameLastnameMagicEightBallServiceApplication.class, args);
	}

}
