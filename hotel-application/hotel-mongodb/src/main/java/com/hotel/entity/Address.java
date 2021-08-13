package com.hotel.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Address {

	@Field(name = "hotel_number")
	private String hotelNumber;

	private String location;

	public String getHotelNumber() {
		return hotelNumber;
	}

	public void setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
