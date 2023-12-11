package com.example.henrymeds.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "providers")
public class Provider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long providerId; 
	
	@Column(name = "first_name")
	private String firstName; 
	
	@Column(name = "last_name")
	private String lastName;
	
	public Provider(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public Provider() {
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	} 
	
	public Long getProviderId() {
		return this.providerId;
	}
}
