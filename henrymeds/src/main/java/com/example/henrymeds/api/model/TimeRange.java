package com.example.henrymeds.api.model;

public class TimeRange {
	
	private String startTime; 
	private String endTime; 
	
	public TimeRange(String startTime, String endTime) {
		this.setStartTime(startTime);
		this.setEndTime(endTime);
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
