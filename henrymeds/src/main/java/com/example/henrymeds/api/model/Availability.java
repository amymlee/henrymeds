package com.example.henrymeds.api.model;

import java.time.LocalDateTime;

public class Availability {
	
	private Long slotId; 
	private String providerName; 
	private LocalDateTime startTime; 
	private LocalDateTime endTime; 
	
	public Availability(Long slotId, String providerName, LocalDateTime startTime, LocalDateTime endTime) {
		this.setSlotId(slotId);
		this.setProviderName(providerName);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
	}

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
}
