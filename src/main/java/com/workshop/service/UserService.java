package com.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.entities.User;
import com.workshop.repositories.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	IUserRepository userRepository;
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		
		return user.get();
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
}
