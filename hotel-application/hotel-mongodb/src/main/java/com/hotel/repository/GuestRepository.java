package com.hotel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Booking;
import com.hotel.entity.Guest;

@Repository
public interface GuestRepository extends MongoRepository<Guest, String> {

	List<Guest> findByFirstName(String firstName);
	
	List<Guest> findByLastName(String lastName);
	
	Guest findByEmailAndFirstName (String email, String firstName);
	
	Guest findByEmailAndLastName (String email, String lastName);
	
	Guest findByFirstNameOrEmail (String firstName, String email);
	
	Guest findByLastNameOrEmail (String lastName, String email);
	
	List<Guest> findByEmailIsLike (String email);
	
	List<Guest> findByFirstNameStartsWith (String firstName);
	
	List<Guest> findByLastNameStartsWith (String lastName);
}
