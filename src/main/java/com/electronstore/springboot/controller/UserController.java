package com.electronstore.springboot.controller;

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
import java.util.Optional;

import com.electronstore.springboot.model.User;
import com.electronstore.springboot.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// C - Create
	@PostMapping("users")
	public String addOrUpdateUser(@RequestBody User user){
		
		userService.addOrUpdateUser(user);
		return "success";
	}
	
	// R - Read
	@GetMapping("users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("users/{userId}")
	public Optional<User> getUserById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
	
	//U - Update
	@PutMapping("users/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody User user){
		User u = null;
		try {
			u = userService.getUserById(userId).orElseThrow(() -> new Exception("user not exist with id: " + userId));
			u.setFirstName(user.getFirstName());
	        u.setLastName(user.getLastName());
	        u.setUsername(user.getUsername());
	        u.setPassword(user.getPassword());
	        u.setUserRole(user.getUserRole());
	        userService.addOrUpdateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	// D - Delete
	@DeleteMapping("users/{userId}")  
	private void deleteUserbyId(@PathVariable int userId)   {  
		this.userService.deleteUserById(userId);   
	}

}
