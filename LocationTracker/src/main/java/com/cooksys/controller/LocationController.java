package com.cooksys.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Location;
import com.cooksys.entity.User;
import com.cooksys.repository.LocationRepository;
import com.cooksys.repository.NumRepository;
import com.cooksys.repository.UserRepository;

@RestController
@RequestMapping("location")
@Transactional
public class LocationController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private NumRepository numRepository;

	//*****************************GET REQUESTS******************************//
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public List<Location> getAll() {
		return locationRepository.findAll();
	}
	
	@RequestMapping(value = "id/{id}", method = RequestMethod.GET)
	public Location getById(@PathVariable("id") Long id) {
		return locationRepository.findOne(id);
	}

	@RequestMapping(value = "name/{name}", method = RequestMethod.GET)
	public Location getByName(@PathVariable("name") String name) {
		return locationRepository.findByName(name);
	}
	
	@RequestMapping(value = "users/locId/{id}", method = RequestMethod.GET)
	public List<User> getUsersByLocation(@PathVariable("id") Long id) {
		return userRepository.findByNum(locationRepository.findOne(id).getNum());
	}
	
	@RequestMapping(value = "users/locName/{name}", method = RequestMethod.GET)
	public List<User> getUsersByLocation(@PathVariable("name") String name) {
		return userRepository.findByNum(locationRepository.findByName(name).getNum());
	}
	
	//*****************************POST REQUESTS******************************//
	
	@RequestMapping(value = "newLoc", method = RequestMethod.POST)
	public String newLoc(@RequestBody Location location) {
		Location loc = locationRepository.findByName(location.getName());
		if (loc == null) {
			location.setHits((long) 0);
			location.setAnonHits((long) 0);
			locationRepository.save(location);
			return "New location saved with name: " + location.getName() + " and num: " + location.getNum();
		}
		return "Location already exists.";
	}
	
	
//	public Location addToLocation(RequestLocation requestLocation, Long n) {
//		if (requestLocation.getTitle() != null) {
//			return createLocation(requestLocation);
//		}
//		
//		Location location = getLocationById(requestLocation.getNum());
//		if (location != null) {
//			if (n > 0) {
//				location.setAnonHits(location.getAnonHits() + n);
//			} else {
//				location.setAnonHits(location.getAnonHits() + n);
//				location.setHits(location.getHits() - n);
//			}
//			locRepo.save(location);
//			return location;
//		}
//		return null;
//	}
	
	@RequestMapping(value = "newUser", method = RequestMethod.POST)
	public String newUser(@RequestBody User user) {
		if (userRepository.findByUsername(user.getUsername()) == null) {
			userRepository.save(user);
			return "New user saved: " + user.getUsername();
		} else {
			return "User already exists.";
			
		}
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestBody User user) {
		
		
		return "";
		
//		if (userRepository.findByUsername(user.getUsername()) != null && userRepository
//				.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())) {
//			return "You logged in as: " + user.getUsername();
//		} else {
//			return "Incorrect login or password.";
//		}
	}
	


}
