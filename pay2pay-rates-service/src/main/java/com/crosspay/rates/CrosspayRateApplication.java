package com.crosspay.rates;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.crosspay.rates.aop.EnableLog;

@SpringBootApplication
@EnableLog
@EnableCaching

public class CrosspayRateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrosspayRateApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}
