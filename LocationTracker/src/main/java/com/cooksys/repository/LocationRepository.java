package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

	Location findByNum(Long num);
	Location findByName(String name);
	@SuppressWarnings("unchecked")
	Location save(Location location);
}
