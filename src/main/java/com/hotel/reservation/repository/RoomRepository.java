package com.hotel.reservation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hotel.reservation.entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
	
	RoomEntity findById(Long id);
}
