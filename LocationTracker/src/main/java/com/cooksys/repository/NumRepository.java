package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Num;

public interface NumRepository extends JpaRepository<Num, Long> {

	Num findByNum(Long num);
	@SuppressWarnings("unchecked")
	Num save(Num num);
}