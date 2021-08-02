package com.hotel.microservices.hotelexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelExchangeRepository 
	extends JpaRepository<HotelExchange, Long> {
	HotelExchange findByFromAndTo(String from, String to);
}
