package com.example.henrymeds.api.model;

public class ClientReservation {
	
	private Long clientId; 
	private Long slotId; 
	
	public ClientReservation(Long clientId, Long slotId) {
		this.setClientId(clientId);
		this.setSlotId(slotId);
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
}
