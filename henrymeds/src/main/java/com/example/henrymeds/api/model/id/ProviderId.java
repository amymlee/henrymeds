package com.example.henrymeds.api.model.id;

public class ProviderId {
	
	private Long providerId; 
	
	public ProviderId(Long providerId) {
		this.setProviderId(providerId); 
	}

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
}
