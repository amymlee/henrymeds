package com.example.henrymeds.api.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.henrymeds.api.entity.Client;
import com.example.henrymeds.api.entity.Provider;
import com.example.henrymeds.api.entity.Reservation;
import com.example.henrymeds.api.entity.TimeSlot;
import com.example.henrymeds.api.model.ReservationStatus;
import com.example.henrymeds.api.repository.ClientRepository;
import com.example.henrymeds.api.repository.ProviderRepository;
import com.example.henrymeds.api.repository.ReservationRepository;
import com.example.henrymeds.api.repository.TimeSlotRepository;
import com.example.henrymeds.api.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	TimeSlotRepository timeSlotRepository; 
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ProviderRepository providerRepository;

	@Override
	public Long createReservation(Long clientId, Long slotId) {
		
		TimeSlot timeSlot = timeSlotRepository.findById(slotId).orElse(null);	
		if (timeSlot == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, 
					String.format("timeSlotId: %d Not Found", slotId));
		}
		
		Client client = clientRepository.findById(clientId).orElse(null);
		if (client == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("clientId: %d Not Found", clientId));
		}
		
		LocalDateTime presentTime = LocalDateTime.now();
		
		/* Reservations must be made 24 hours in advance */
		if (presentTime.plusHours(24).isAfter(timeSlot.getStartTime())) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, 
					String.format("timeSlotId: %d must be reserved at least 24 hours in advance", slotId));
		}
		
		/* Create new reservation entry if both slot and client exist */
		Reservation reservation = new Reservation(
				timeSlot.getSlotId(), timeSlot.getProviderId(), 
				client.getClientId(), timeSlot.getStartTime(), 
				timeSlot.getEndTime());
		
		reservationRepository.save(reservation);
		
		/* Update the availability status of the time slot */
		timeSlot.setAvailable(false);
		timeSlotRepository.save(timeSlot);
		
		return reservation.getReservationId();
	}

	@Override
	public String confirmReservation(Long clientId, Long reservationId) {
		Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
		Client client = clientRepository.findById(clientId).orElse(null);
		
		if (reservation == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, 
					String.format("reservationId: %d Not Found", reservationId));
		}
		
		if (client == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("clientId: %d Not Found", clientId));
		}
		
		if (reservation.getClientId() != clientId) {
			throw new ResponseStatusException(
					HttpStatus.FORBIDDEN, 
					String.format("clientId: %d does not have "
							+ "permission to confirm reservationId: %d", clientId, reservationId));
		}

		reservation.setStatus(ReservationStatus.CONFIRMED);
		reservationRepository.save(reservation);
		
		Provider provider = providerRepository.getReferenceById(reservation.getProviderId());
		
		String confirmationMessage = String.format("You have successfully "
				+ "confirmed your reservation to see Dr. %s %s for the following time: %s", 
				provider.getFirstName(), 
				provider.getLastName(), 
				reservation.getStartTime().toString());
		
		return confirmationMessage;
	}

	@Override
	public void unscheduleReservation(Reservation reservation) {
		if (reservation.getStatus().equals(ReservationStatus.SCHEDULED)) {
			TimeSlot timeSlot = timeSlotRepository.findById(reservation.getSlotId()).orElse(null); 
			if (timeSlot == null) {
				throw new ResponseStatusException(
						HttpStatus.INTERNAL_SERVER_ERROR, 
						String.format("timeSlot not found for reservationId: %s", reservation.getSlotId()));
			}
			
			timeSlot.setAvailable(true);
			reservation.setStatus(ReservationStatus.UNSCHEDULED);
			
			timeSlotRepository.save(timeSlot); 
			reservationRepository.save(reservation);
		}
	}

	@Override
	public List<Reservation> getAllUnconfirmedReservations() {
		return reservationRepository.findAll().stream()
				.filter(reservation -> reservation.getStatus().equals(ReservationStatus.SCHEDULED))
				.toList();
	}
}
