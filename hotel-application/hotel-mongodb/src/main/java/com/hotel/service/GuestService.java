package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hotel.entity.Booking;
import com.hotel.entity.Guest;
import com.hotel.repository.GuestRepository;

@Service
public class GuestService {
	
	@Autowired
	GuestRepository guestRepository;

	public Guest createGuest (Guest guest) {
		return guestRepository.save(guest);
	}
	
	public Guest getGuestbyId(String id) {
		return guestRepository.findById(id).get();
	}
	
	public List<Guest> getAllGuests() {
		return guestRepository.findAll();
	}
	
	public Guest updateGuest (Guest guest) {
		return guestRepository.save(guest);
	}
	
	public String deleteGuest (String id) {
		guestRepository.deleteById(id);
		return "Guest has been deleted.";
	}
	
	public List<Guest> getGuestsByFirstName (String firstName) {
		return guestRepository.findByFirstName(firstName);
	}
	
	public List<Guest> getGuestsByLastName (String lastName) {
		return guestRepository.findByLastName(lastName);
	}
	
	public Guest guestsByFirstNameAndMail (String firstName, String email) {
		return guestRepository.findByEmailAndFirstName(email, firstName);
	}
	
	public Guest guestsByLastNameAndMail (String lastName, String email) {
		return guestRepository.findByEmailAndLastName(email, lastName);
	}
	
	public Guest guestsByFirstNameOrMail (String firstName, String email) {
		return guestRepository.findByFirstNameOrEmail(firstName, email);
	}
	
	public Guest guestsByLastNameOrMail (String lastName, String email) {
		return guestRepository.findByLastNameOrEmail(lastName, email);
	}
	
	public List<Guest> getAllWithPagination (int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return guestRepository.findAll(pageable).getContent();
	}
	
	public List<Guest> allWithSorting () {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName", "email");
		
		return guestRepository.findAll(sort);		
	}

	public List<Guest> emailLike (String email) {
		return guestRepository.findByEmailIsLike(email);
	}
	
	public List<Guest> firstNameStartsWith (String firstName) {
		return guestRepository.findByFirstNameStartsWith(firstName);
	}
	
	public List<Guest> lastNameStartsWith (String lastName) {
		return guestRepository.findByLastNameStartsWith(lastName);
	}	
}
