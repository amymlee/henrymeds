package com.example.henrymeds.api.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.henrymeds.api.entity.Provider;
import com.example.henrymeds.api.entity.TimeSlot;
import com.example.henrymeds.api.model.Availability;
import com.example.henrymeds.api.model.TimeRange;
import com.example.henrymeds.api.repository.ProviderRepository;
import com.example.henrymeds.api.repository.TimeSlotRepository;
import com.example.henrymeds.api.service.TimeSlotService;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {
	
	@Autowired
	TimeSlotRepository timeSlotRepository; 
	
	@Autowired 
	ProviderRepository providerRepository;

	@Override
	public void generateAvailabilities(Long providerId, List<TimeRange> timeRanges) {
		Provider provider = providerRepository.getReferenceById(providerId);
		String providerName = String.format("%s %s", provider.getFirstName(), provider.getLastName());
		
		for (TimeRange time : timeRanges) {
			LocalDateTime startTime = LocalDateTime.parse(time.getStartTime());
			LocalDateTime endTime = LocalDateTime.parse(time.getEndTime());
			
			while (startTime.isBefore(endTime)) {
				LocalDateTime nextEndTime = startTime.plusMinutes(15);
				
				/* Only create time slots if there is the full allotted 15 minutes*/
				if (nextEndTime.isBefore(endTime) || nextEndTime.isEqual(endTime)) {
					TimeSlot timeSlot = new TimeSlot(providerId, providerName, startTime, nextEndTime);
					timeSlotRepository.save(timeSlot);
				}
				
				startTime = startTime.plusMinutes(15); 
			}
		}
	}

	@Override
	public List<Availability> getAllAvailableSlots() {
		
		List<TimeSlot> timeSlots = timeSlotRepository.findAll()
				.stream()
				.filter(timeslot -> timeslot.isAvailable())
				.toList();
		
		List<Availability> availabilities = new ArrayList<>(); 
		
		for (TimeSlot timeSlot : timeSlots) {
			availabilities.add(
					new Availability(
							timeSlot.getSlotId(), 
							timeSlot.getProviderName(), 
							timeSlot.getStartTime(), 
							timeSlot.getEndTime()
							)
					);
		}
		
		return availabilities; 
	}
}
