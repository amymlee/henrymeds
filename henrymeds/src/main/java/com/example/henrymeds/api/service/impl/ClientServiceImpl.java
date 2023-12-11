package com.example.henrymeds.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.henrymeds.api.entity.Client;
import com.example.henrymeds.api.repository.ClientRepository;
import com.example.henrymeds.api.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired 
	ClientRepository clientRepository;

	@Override
	public Long saveClient(Client client) {
		clientRepository.save(client);
		return client.getClientId();
	}

	@Override
	public Client getClient(Long id) {
		return clientRepository.getReferenceById(id);
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
}
