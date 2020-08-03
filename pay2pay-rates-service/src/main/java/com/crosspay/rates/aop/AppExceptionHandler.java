package com.crosspay.rates.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Object> generateResponse(Exception ex) {
		System.out.println(ex.getClass()+" - "+ex.getMessage());
		Map map = new HashMap<>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(500).headers(new HttpHeaders()).body(map);
	}

}
