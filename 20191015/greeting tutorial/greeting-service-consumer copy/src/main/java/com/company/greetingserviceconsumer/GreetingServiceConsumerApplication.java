package com.company.greetingserviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class GreetingServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingServiceConsumerApplication.class, args);
	}

}
