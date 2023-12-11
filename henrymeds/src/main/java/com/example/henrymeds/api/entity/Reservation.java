package com.example.henrymeds.api.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.henrymeds.api.model.ReservationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reservationId; 
	
	@Column(name = "slot_id")
	private Long slotId; 
	
	@Column(name = "provider_id")
	private Long providerId; 
	
	@Column(name = "client_id")
	private Long clientId;  
	
	@Column(name = "start_time")
	private LocalDateTime startTime; 

	@Column(name = "end_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime endTime;
	
	@Column(name = "created_at")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime createdAt;
	
	@Column(name = "reservation_status")
	@Enumerated(EnumType.STRING)
	private ReservationStatus status;
	
	public Reservation(Long slotId, Long providerId, Long clientId, LocalDateTime startTime, LocalDateTime endTime) {
		this.setSlotId(slotId);
		this.setProviderId(providerId);
		this.setClientId(clientId);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
		this.createdAt = LocalDateTime.now();
		this.setStatus(ReservationStatus.SCHEDULED);
	}
	
	public Reservation() {
	}
	
	public Long getReservationId() {
		return reservationId; 
	}

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
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
	
	public LocalDateTime getCreatedAt() {
		return createdAt; 
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}
}
