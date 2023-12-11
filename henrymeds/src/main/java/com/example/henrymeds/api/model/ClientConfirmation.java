package com.example.henrymeds.api.model;

public class ClientConfirmation {
	
	private Long clientId; 
	private Long reservationId; 
	
	public ClientConfirmation(Long clientId, Long reservationId) {
		this.setClientId(clientId);
		this.setReservationId(reservationId);		
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
}
