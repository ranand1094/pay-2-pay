package com.app.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.app.demo.services.helper.ServiceHelper;

@SpringBootApplication
@ComponentScan(basePackages = {"com.app"})//scans even in entities
public class Pay2Pay {

	public static void main(String[] args) {
		SpringApplication.run(Pay2Pay.class, args);
	} 

	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper mm = new ModelMapper();
		return mm;
	}
	
	@Bean
	public ServiceHelper getHelp() {
		return new ServiceHelper();
	}
} 