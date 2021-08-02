package com.hotel.microservices.hotelregistrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HotelRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRegistrationServiceApplication.class, args);
	}

}
