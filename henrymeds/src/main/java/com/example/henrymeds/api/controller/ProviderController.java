package com.example.henrymeds.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.henrymeds.api.entity.Provider;
import com.example.henrymeds.api.model.ProviderTimes;
import com.example.henrymeds.api.model.id.ProviderId;
import com.example.henrymeds.api.service.ProviderService;
import com.example.henrymeds.api.service.TimeSlotService;

@RestController
@RequestMapping("/provider")
public class ProviderController {
	
	@Autowired
	private TimeSlotService timeSlotService; 
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	public ProviderController(TimeSlotService timeSlotService, ProviderService providerService) {
		this.timeSlotService = timeSlotService;
		this.providerService = providerService;
	}
	
	@PostMapping("/new") 
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ProviderId saveNewProvider(@RequestBody Provider provider) {
		Long providerId = providerService.saveProvider(provider);
		return new ProviderId(providerId);
	}
	
	@PostMapping("/availabilities")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity submitNewAvailabilities(@RequestBody ProviderTimes providerTimes) {
		timeSlotService.generateAvailabilities(providerTimes.getProviderId(), providerTimes.getTimeRanges());
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
