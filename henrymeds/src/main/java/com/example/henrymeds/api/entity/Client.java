package com.example.henrymeds.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientId; 
	
	@Column(name = "first_name")
	private String firstName; 
	
	@Column(name = "last_name")
	private String lastName; 
	
	public Client(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public Client() {
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
	
	public Long getClientId() {
		return this.clientId;
	}
}
