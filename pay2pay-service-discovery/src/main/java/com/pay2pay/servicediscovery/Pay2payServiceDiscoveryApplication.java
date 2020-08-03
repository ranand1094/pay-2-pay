package com.pay2pay.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Pay2payServiceDiscoveryApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(Pay2payServiceDiscoveryApplication.class, args);
	}

}
