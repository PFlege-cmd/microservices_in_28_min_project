package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.exceptions.TableNotFoundException;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	Environment environment;
	
	@Autowired
	CurrencyExchangeRepository repository;
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange  retrieveExchangeValue(@PathVariable String from, 
			@PathVariable String to) {
//		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, "USD", "INR", 
//						BigDecimal.valueOf(50.0));
//		
		logger.info("Logged request from {} to {}!", from, to);
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		if (currencyExchange == null)
			throw new TableNotFoundException("Data not found");
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		
		return currencyExchange;
	}

}
