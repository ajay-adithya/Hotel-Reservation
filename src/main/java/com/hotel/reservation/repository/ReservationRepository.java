package com.hotel.reservation.repository;

import org.springframework.data.repository.CrudRepository;

import com.hotel.reservation.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
}