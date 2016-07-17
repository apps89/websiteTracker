package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByNum(Long num);
	User findByUsername(String username);
	@SuppressWarnings("unchecked")
	User save(User user);
}
