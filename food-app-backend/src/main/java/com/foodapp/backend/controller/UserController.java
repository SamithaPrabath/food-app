package com.foodapp.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.backend.model.User;
import com.foodapp.backend.service.UserService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" },allowedHeaders = "*")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("getUser/{userName}")
	public List<User> getUser(@PathVariable String userName){
		return userService.getUserDetails(userName);
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/editUser")
	public String updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{userName}")
	public String deleteUser(@PathVariable String userName) {
		return userService.deleteUser(userName);
	}

}
