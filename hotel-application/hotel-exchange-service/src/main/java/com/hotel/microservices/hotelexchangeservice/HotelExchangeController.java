package com.hotel.microservices.hotelexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(HotelExchangeController.class);
	
	@Autowired
	private HotelExchangeRepository repository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/hotel-exchange/from/{from}/to/{to}")
	public HotelExchange retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to) {
		
		logger.info("retrieveExchangeValue called with {} to {}", from, to);
		
		HotelExchange hotelExchange 
					= repository.findByFromAndTo(from, to);
		
		if(hotelExchange ==null) {
			throw new RuntimeException
				("Unable to Find data for " + from + " to " + to);
		}
		
		String port = environment.getProperty("local.server.port");
		
		String host = environment.getProperty("HOSTNAME");
		String version = "v0.1";
		
		hotelExchange.setEnvironment(port + " " + version + " " + host);
		
		return hotelExchange;
		
	}

}
