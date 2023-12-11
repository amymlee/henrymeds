package com.example.henrymeds.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.henrymeds.api.entity.Reservation;

@Service
public interface ReservationService {
	
	/**
	 * Creates a new reservation with the client and the given availability using 
	 * its slot id
	 * 
	 * @param clientId
	 * @param slotId
	 * @return
	 */
	Long createReservation(Long clientId, Long slotId);
	
	/**
	 * Sets the reservation as confirmed and generates a confirmation message
	 * 
	 * @param clientId
	 * @param reservationId
	 */
	String confirmReservation(Long clientId, Long reservationId);
	
	/**
	 * De-schedule a reservation when 30 minutes have passed
	 * and the reservation has not been confirmed 
	 * 
	 * @param reservationId
	 */
	void unscheduleReservation(Reservation reservation);
	
	/**
	 * Obtains all reservations where appointments have not been confirmed
	 * 
	 * @return list of all unconfirmed reservations
	 */
	List<Reservation> getAllUnconfirmedReservations();
}
