package com.example.henrymeds.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.henrymeds.api.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
