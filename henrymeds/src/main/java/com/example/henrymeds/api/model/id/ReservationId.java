package com.example.henrymeds.api.model.id;

public class ReservationId {
	
	private Long reservationId; 
	
	public ReservationId(Long reservationId) {
		this.setReservationId(reservationId);
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
}
