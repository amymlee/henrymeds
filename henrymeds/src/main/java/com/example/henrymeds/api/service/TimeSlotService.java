package com.example.henrymeds.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.henrymeds.api.model.Availability;
import com.example.henrymeds.api.model.TimeRange;

@Service
public interface TimeSlotService {
	
	/**
	 * Generates 15-minute time slots based on the availabilities 
	 * provided by the provider 
	 * 
	 * @param providerTimes
	 */
	void generateAvailabilities(Long providerId, List<TimeRange> timeRanges);
	
	/**
	 * Gets all the available time slots 
	 * 
	 * @return all time slots that can be reserved by the client
	 */
	List<Availability> getAllAvailableSlots(); 
}
