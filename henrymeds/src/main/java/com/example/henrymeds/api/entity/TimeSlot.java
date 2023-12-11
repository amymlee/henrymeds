package com.example.henrymeds.api.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="time_slots")
public class TimeSlot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long slotId; 
	
	@Column(name = "provider_id")
	private Long providerId; 
	
	@Column(name = "provider_name")
	private String providerName; 
	
	@Column(name = "start_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime startTime; 
	
	@Column(name = "end_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime endTime; 
	
	@Column(name = "is_available")
	private boolean isAvailable; 
	
	public TimeSlot(Long providerId, String providerName, LocalDateTime startTime, LocalDateTime endTime) {
		this.setProviderId(providerId);
		this.setProviderName(providerName);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
		this.setAvailable(true);
	}
	
	public TimeSlot() {
	}
	
	public Long getSlotId() {
		return slotId;
	}

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
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

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}

