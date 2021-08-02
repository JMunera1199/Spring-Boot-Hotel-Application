package com.hotel.microservices.hotelregistrationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "hotel-x", url = "${HOTEL_X_URI:http://localhost}:8000")
@FeignClient(name="hotel-exchange")
public interface HotelExchangeProxy {
	
	@GetMapping("/hotel-exchange/from/{from}/to/{to}")
	public HotelRegistration retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to);

}
