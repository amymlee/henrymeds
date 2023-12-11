package com.example.henrymeds.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.henrymeds.api.entity.Provider;

@Service
public interface ProviderService {
	
	Long saveProvider(Provider provider);
	
	Provider getProvider(Long id); 
	
	List<Provider> getAllProviders();
}
