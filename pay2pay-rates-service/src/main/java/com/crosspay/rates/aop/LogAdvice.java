package com.crosspay.rates.aop;

 
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LogAdvice {
	
	
	@Around(value = "@annotation(com.crosspay.rates.aop.EnableLog)")
	public Object appLog(ProceedingJoinPoint jointPoints) throws Throwable {
		Logger log = LoggerFactory.getLogger(LogAdvice.class);
		ObjectMapper mapper = new ObjectMapper();
		
		String methodName = jointPoints.getSignature().getName();//gets method name
		String className = jointPoints.getTarget().getClass().getName();
		
		Object[] inputs = jointPoints.getArgs();
		log.info("**Class Name :- "+className+"** Method Name :- "+methodName+"**Inputs :- "+mapper.writeValueAsString(inputs));
		Object output = jointPoints.proceed();
		log.info("**Class Name :- "+className+"** Method Name :- "+methodName+"**Outputs :- "+mapper.writeValueAsString(output));
		
		return output;
		
	}

}
