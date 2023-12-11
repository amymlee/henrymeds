package com.example.henrymeds.api.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.henrymeds.api.entity.Client;
import com.example.henrymeds.api.model.Availability;
import com.example.henrymeds.api.model.ClientConfirmation;
import com.example.henrymeds.api.model.ClientReservation;
import com.example.henrymeds.api.model.id.ClientId;
import com.example.henrymeds.api.model.id.ReservationId;
import com.example.henrymeds.api.service.ClientService;
import com.example.henrymeds.api.service.ReservationService;
import com.example.henrymeds.api.service.TimeSlotService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private TimeSlotService timeSlotService; 
	
	@Autowired 
	private ClientService clientService; 
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	public ClientController(TimeSlotService timeSlotService, ClientService clientService, ReservationService reservationService) {
		this.timeSlotService = timeSlotService;
		this.clientService = clientService;
		this.reservationService = reservationService;
	}
	
	@PostMapping("/new")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ClientId saveNewClient(@RequestBody Client client) {
		Long clientId = clientService.saveClient(client);
		return new ClientId(clientId);
	}
	
	@GetMapping("/availabilities")
	@ResponseStatus(HttpStatus.OK)
	public List<Availability> getAllAvailableSlots() {
		return timeSlotService.getAllAvailableSlots();
	}
	
	@PostMapping("/reserve")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ReservationId createNewReservation(
			@RequestBody ClientReservation reservation) {
		
		Long clientId = reservation.getClientId();
		Long slotId = reservation.getSlotId(); 
		
		Long reservationId = reservationService.createReservation(clientId, slotId);
		
		return new ReservationId(reservationId);
	}
	
	@PutMapping("/confirm")
	@ResponseStatus(HttpStatus.OK)
	public String confirmReservation(
			@RequestBody ClientConfirmation confirmation) {

		Long clientId = confirmation.getClientId(); 
		Long reservationId = confirmation.getReservationId();
		
		String message = reservationService.confirmReservation(clientId, reservationId);
		return message;
	}
}
