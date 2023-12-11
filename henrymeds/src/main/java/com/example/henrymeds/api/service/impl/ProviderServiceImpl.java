package com.example.henrymeds.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.henrymeds.api.entity.Provider;
import com.example.henrymeds.api.repository.ProviderRepository;
import com.example.henrymeds.api.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {
	
	@Autowired
	ProviderRepository providerRepository;

	@Override
	public Long saveProvider(Provider provider) {
		providerRepository.save(provider);
		return provider.getProviderId();
	}

	@Override
	public Provider getProvider(Long id) {
		return providerRepository.getReferenceById(id);
	}

	@Override
	public List<Provider> getAllProviders() {
		return providerRepository.findAll();
	}
}
