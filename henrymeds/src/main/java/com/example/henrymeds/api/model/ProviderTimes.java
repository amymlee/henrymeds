package com.example.henrymeds.api.model;

import java.util.List;

public class ProviderTimes {
	
	private Long providerId; 
	private List<TimeRange> timeRanges; 
	
	public ProviderTimes(Long providerId, List<TimeRange> timeRanges) {
		this.setProviderId(providerId);
		this.setTimeRanges(timeRanges);
	}

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public List<TimeRange> getTimeRanges() {
		return timeRanges;
	}

	public void setTimeRanges(List<TimeRange> timeRanges) {
		this.timeRanges = timeRanges;
	}
}
