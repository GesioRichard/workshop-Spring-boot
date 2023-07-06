package com.workshop.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.workshop.entities.User;
import com.workshop.repositories.IUserRepository;
import com.workshop.service.exceptions.DatabaseException;
import com.workshop.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	IUserRepository userRepository;

	public User findById(Long id) {
		try {
			Optional<User> user = userRepository.findById(id);

			return user.get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User insert(User user) {
		return userRepository.save(user);
	}

	public User update(Long id, User newUser) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateUser(entity, newUser);

			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void deleteById(Long id) {
		try {
			userRepository.deleteById(id);
		} catch ( DataIntegrityViolationException e ) {
			throw new DatabaseException(e.getMessage());
		}
	}

	private void updateUser(User entity, User newUser) {
		entity.setName(newUser.getName());
		entity.setEmail(newUser.getEmail());
		entity.setPhone(newUser.getPhone());
	}
}
