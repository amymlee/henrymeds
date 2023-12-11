package com.example.henrymeds.api.model.id;

public class ClientId {
	
	private Long clientId; 
	
	public ClientId(Long clientId) {
		this.setClientId(clientId);
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
}
