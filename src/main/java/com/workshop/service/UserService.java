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
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public User update(Long id, User newUser) {
		User entity = userRepository.getReferenceById(id);
		updateUser(entity, newUser);
		return userRepository.save(entity);
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	private void updateUser(User entity, User newUser) {
		entity.setName(newUser.getName());
		entity.setEmail(newUser.getEmail());
		entity.setPhone(newUser.getPhone());
	}
}
