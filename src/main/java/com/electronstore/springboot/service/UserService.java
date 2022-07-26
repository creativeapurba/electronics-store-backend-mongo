package com.electronstore.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronstore.springboot.model.User;
import com.electronstore.springboot.model.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addOrUpdateUser(User user) {
		return userRepository.save(user); 
	}
	
	public List<User> getAllUsers(){		
		return userRepository.findAll();	
	}

	public Optional<User> getUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

	public void deleteUserById(int userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
		
	}
}
