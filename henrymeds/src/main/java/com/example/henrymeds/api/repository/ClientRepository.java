package com.example.henrymeds.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.henrymeds.api.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
