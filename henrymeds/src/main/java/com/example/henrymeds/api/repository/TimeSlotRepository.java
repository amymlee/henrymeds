package com.example.henrymeds.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.henrymeds.api.entity.TimeSlot;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long>{
	

}
