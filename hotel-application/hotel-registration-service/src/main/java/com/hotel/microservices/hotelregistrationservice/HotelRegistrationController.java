package com.hotel.microservices.hotelregistrationservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HotelRegistrationController {
	
	private Logger logger = LoggerFactory.getLogger(HotelRegistrationController.class);
	
	@Autowired
	private HotelExchangeProxy proxy;
	
	@GetMapping("/hotel-registration/from/{from}/to/{to}/quantity/{quantity}")
	public HotelRegistration calculateHotelRegistration(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		logger.info("calculateHotelRegistration called with {} to {} with {}", from, to, quantity);
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		
		ResponseEntity<HotelRegistration> responseEntity = new RestTemplate().getForEntity
		("http://localhost:8000/hotel-x/from/{from}/to/{to}", 
				HotelRegistration.class, uriVariables);
		
		HotelRegistration hotelRegistration = responseEntity.getBody();
		
		return new HotelRegistration(hotelRegistration.getId(), 
				from, to, quantity, 
				hotelRegistration.getConversionMultiple(), 
				quantity.multiply(hotelRegistration.getConversionMultiple()), 
				hotelRegistration.getEnvironment()+ " " + "rest template");
		
	}

	@GetMapping("/hotel-registration-feign/from/{from}/to/{to}/quantity/{quantity}")
	public HotelRegistration calculateHotelRegistrationFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		logger.info("calculateHotelRegistrationFeign called with {} to {} with {}", from, to, quantity);

		HotelRegistration hotelRegistration = proxy.retrieveExchangeValue(from, to);
		
		return new HotelRegistration(hotelRegistration.getId(), 
				from, to, quantity, 
				hotelRegistration.getConversionMultiple(), 
				quantity.multiply(hotelRegistration.getConversionMultiple()), 
				hotelRegistration.getEnvironment() + " " + "feign");
		
	}


}
