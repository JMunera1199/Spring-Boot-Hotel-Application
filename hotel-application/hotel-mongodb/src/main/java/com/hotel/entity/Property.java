package com.hotel.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Property {

	@Field(name = "property_number")
	private String propertyNumber;

	private String location;

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
