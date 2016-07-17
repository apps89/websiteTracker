package com.cooksys.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Num;
import com.cooksys.entity.User;
import com.cooksys.repository.LocationRepository;
import com.cooksys.repository.NumRepository;
import com.cooksys.repository.UserRepository;

@RestController
@RequestMapping("num")
@Transactional
public class NumController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private NumRepository numRepository;

	//*****************************GET REQUESTS******************************//
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public List<Num> getAll() {
		return numRepository.findAll();
	}
	
	@RequestMapping(value = "id/{id}", method = RequestMethod.GET)
	public Num getById(@PathVariable("id") Long id) {
		return numRepository.findOne(id);
	}

	@RequestMapping(value = "num/{num}", method = RequestMethod.GET)
	public Num getByNum(@PathVariable("num") Long num) {
		return numRepository.findByNum(num);
	}
	
	//*****************************POST REQUESTS******************************//
	
	@RequestMapping(value = "newNum", method = RequestMethod.POST)
	public String newNum(@RequestBody Num num) {
		if (numRepository.findByNum(num.getNum()) == null) {
			numRepository.save(num);
			return "New num saved: " + num.getNum() + " with id=" + num.getId();
		}
		return "Num already exists.";
	}
	
	@RequestMapping(value = "incrementNum", method = RequestMethod.POST)
	public String incrementNum(@RequestBody Num num) {
		
		
		return "";
	}
}
		