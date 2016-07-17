package com.cooksys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Location;
import com.cooksys.entity.Num;
import com.cooksys.entity.User;
import com.cooksys.model.UserModel;
import com.cooksys.repository.LocationRepository;
import com.cooksys.repository.NumRepository;
import com.cooksys.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	NumRepository numRepository;

	public String login(User user, UserModel userModel) {
		User dbUser = userRepository.findByUsername(user.getUsername());
		if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
			userModel.setNumLoggedUsers(userModel.getNumLoggedUsers() + 1);
			userModel.setTotal(userModel.getTotal() + 1);
			incrementHits(dbUser.getNum());
			return "You logged in as: " + dbUser.getUsername() + "\nHits: " + getHits(dbUser.getNum()) + " AnonHits: "
					+ getAnonHits(dbUser.getNum()) + " for " + getLocationName(dbUser.getNum());
		}
		return "Incorrect login or password.";
	}

	public String unregistered(Num num, UserModel userModel) {
		if (numRepository.findByNum(num.getNum()) != null) {
			userModel.setNumAnonymous(userModel.getNumAnonymous() + 1);
			userModel.setTotal(userModel.getTotal() + 1);
			incrementAnonHits(num.getNum());
			return "Hits: " + getHits(num.getNum()) + " AnonHits: " + getAnonHits(num.getNum()) + " for "
					+ getLocationName(num.getNum());
		}
		return "Location does not exist";
	}

	public void incrementHits(Long num) {
		Location location = locationRepository.findByNum(num);
		if (location != null) {
			location.setHits(location.getHits() + 1);
			locationRepository.save(location);
		}
	}

	public void incrementAnonHits(Long num) {
		Location location = locationRepository.findByNum(num);
		if (location != null) {
			location.setAnonHits(location.getAnonHits() + 1);
		}
	}

	public Long getHits(Long num) {
		return locationRepository.findByNum(num).getHits();
	}

	public Long getAnonHits(Long num) {
		return locationRepository.findByNum(num).getAnonHits();
	}

	public String getLocationName(Long num) {
		return locationRepository.findByNum(num).getName();
	}

}