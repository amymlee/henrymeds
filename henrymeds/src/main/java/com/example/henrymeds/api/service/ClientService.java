package com.example.henrymeds.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.henrymeds.api.entity.Client;

@Service
public interface ClientService {
	
	Long saveClient(Client client); 
	
	Client getClient(Long id);
	
	List<Client> getAllClients();

}
