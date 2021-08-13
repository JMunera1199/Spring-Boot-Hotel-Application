package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Booking;
import com.hotel.entity.Guest;
import com.hotel.service.GuestService;

@RestController
@RequestMapping("/api/guest")
public class GuestController {
	
	@Autowired
	GuestService guestService;

	@PostMapping("/create")
	public Guest createGuest(@RequestBody Guest guest) {
		return guestService.createGuest(guest);
	}
	
	@GetMapping("/getById/{id}")
	public Guest getGuestbyId(@PathVariable String id) {
		return guestService.getGuestbyId(id);
	}
	
	@GetMapping("/all")
	public List<Guest> getAllGuests() {
		return guestService.getAllGuests();
	}
	
	@PutMapping("/update")
	public Guest updateGuest(@RequestBody Guest guest) {
		return guestService.updateGuest(guest);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteGuest(@PathVariable String id) {
		return guestService.deleteGuest(id);
	}
	
	@GetMapping("/guestsByFirstName/{firstName}")
	public List<Guest> guestsByFirstName(@PathVariable String firstName) {
		return guestService.getGuestsByFirstName(firstName);
	}
	
	@GetMapping("/guestsByLastName/{lastName}")
	public List<Guest> guestsByLastName(@PathVariable String lastName) {
		return guestService.getGuestsByLastName(lastName);
	}
	
	@GetMapping("/guestsByFirstNameAndMail")
	public Guest guestsByFirstNameAndMail(@RequestParam String firstName,
			@RequestParam String email) {
		return guestService.guestsByFirstNameAndMail(firstName, email);
	}
	
	@GetMapping("/guestsByFirstNameOrMail")
	public Guest guestsByFirstNameOrMail(@RequestParam String firstName,
			@RequestParam String email) {
		return guestService.guestsByFirstNameOrMail(firstName, email);
	}
	
	@GetMapping("/guestsByLastNameAndMail")
	public Guest guestsByLastNameAndMail(@RequestParam String lastName,
			@RequestParam String email) {
		return guestService.guestsByLastNameAndMail(lastName, email);
	}
	
	@GetMapping("/guestsByLastNameOrMail")
	public Guest guestsByLastNameOrMail(@RequestParam String lastName,
			@RequestParam String email) {
		return guestService.guestsByFirstNameOrMail(lastName, email);
	}
	
	@GetMapping("/allWithPagination")
	public List<Guest> getAllWithPagination(@RequestParam int pageNo,
			@RequestParam int pageSize) {
		return guestService.getAllWithPagination(pageNo, pageSize);
	}
	
	@GetMapping("/allWithSorting")
	public List<Guest> allWithsSorting() {
		return guestService.allWithSorting();
	}
	
	@GetMapping("/emailLike")
	public List<Guest> emailLike(@RequestParam String email) {
		return guestService.emailLike(email);
	}
	
	@GetMapping("/lastNameStartsWith")
	public List<Guest> lastNameStartsWith(@RequestParam String lastName) {
		return guestService.lastNameStartsWith(lastName);
	}
	
}
