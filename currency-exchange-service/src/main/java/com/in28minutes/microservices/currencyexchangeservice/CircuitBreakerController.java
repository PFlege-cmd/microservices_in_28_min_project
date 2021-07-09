package com.in28minutes.microservices.currencyexchangeservice;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	//@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	//@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	@RateLimiter(name = "default")
	@Bulkhead(name = "simple-api")
	@GetMapping("/simple-api")
	public String api_service(){
		logger.info("Api call re-tried!");
//		ResponseEntity<String> forEntity = new RestTemplate()
//				.getForEntity("http://localhost:8080/dummy-api", String.class);
//		
//		
//		return forEntity.getBody();
		return "Simple Api";
	}
	
	public String hardcodedResponse(Throwable thr) {
		return "Hardcoded response";
	}

}
