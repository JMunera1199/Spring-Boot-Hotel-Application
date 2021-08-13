package com.hotel.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Booking {

	@Field(name = "booking_number")
	private String bookingNumber;

	@Field(name = "numberOfStays")
	private int numberOfStays;

	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public int getNumberOfStays() {
		return numberOfStays;
	}

	public void setNumberOfStays(int numberOfStays) {
		this.numberOfStays = numberOfStays;
	}

}
