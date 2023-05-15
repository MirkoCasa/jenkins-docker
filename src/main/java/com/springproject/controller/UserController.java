package com.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.model.User;
import com.springproject.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findById(@PathVariable Integer id) {
		User user = null;
		if(userRepository.existsById(id)) {
			user = userRepository.findById(id).get();
		}
		return user;
	}
	
	@PutMapping("/users/new")
	public User save(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@DeleteMapping("/users/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
	
}
