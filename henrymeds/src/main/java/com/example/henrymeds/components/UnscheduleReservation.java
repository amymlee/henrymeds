package com.example.henrymeds.components;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.henrymeds.api.entity.Reservation;
import com.example.henrymeds.api.service.ReservationService;

@Component
public class UnscheduleReservation {
	
	@Autowired
	ReservationService reservationService;
	
	@Scheduled(cron = "0 0/1 * * * ?")
	public void unscheduleReservations() {
		List<Reservation> reservations = reservationService.getAllUnconfirmedReservations();
		for (Reservation reservation : reservations) {
			LocalDateTime createdAt = reservation.getCreatedAt();
			if (createdAt.plusMinutes(30).isBefore(LocalDateTime.now())) {
				reservationService.unscheduleReservation(reservation);
			}
		}
	}
}
