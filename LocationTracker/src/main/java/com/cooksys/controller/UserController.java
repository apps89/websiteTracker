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
import com.cooksys.model.UserModel;
import com.cooksys.repository.LocationRepository;
import com.cooksys.repository.NumRepository;
import com.cooksys.repository.UserRepository;
import com.cooksys.services.UserService;

@RestController
@RequestMapping("user")
@Transactional
public class UserController {

	private UserModel userModel = new UserModel();

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private NumRepository numRepository;
	
	@Autowired
	private UserService userService;

	// *****************************GET REQUESTS******************************//

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@RequestMapping(value = "id/{id}", method = RequestMethod.GET)
	public User getById(@PathVariable("id") Long id) {
		return userRepository.findOne(id);
	}

	@RequestMapping(value = "username/{username}", method = RequestMethod.GET)
	public User getByUsername(@PathVariable("username") String username) {
		return userRepository.findByUsername(username);
	}
	
	@RequestMapping(value = "getUserModel", method = RequestMethod.GET)
	public UserModel getUserModel() {
		return userModel;
	}

	// *****************************POST/PUT REQUESTS******************************//

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@RequestBody User user) {
		if (userRepository.findByUsername(user.getUsername()) == null) {
			userRepository.save(user);
			userModel.setNumRegUsers(userModel.getNumRegUsers() + 1);
			userModel.setTotal(userModel.getTotal() + 1);
			return "New user saved: " + user.getUsername();
		} else {
			return "User already exists.";
		}
	}
	
	@RequestMapping(value = "unregistered", method = RequestMethod.PUT)
	public String unregistered(@RequestBody Num num) {
		return userService.unregistered(num, userModel);
	}

	@RequestMapping(value = "login", method = RequestMethod.PUT)
	public String login(@RequestBody User user) {
		return userService.login(user, userModel);
	}
	
}
