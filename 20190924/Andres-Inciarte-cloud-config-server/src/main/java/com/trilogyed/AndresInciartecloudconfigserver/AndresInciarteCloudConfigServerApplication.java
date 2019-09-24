package com.trilogyed.AndresInciartecloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AndresInciarteCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndresInciarteCloudConfigServerApplication.class, args);
	}

}
