package com.workshop.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.entities.Category;
import com.workshop.repositories.ICategoryRepository;
import com.workshop.service.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	public Category findById(Long id) {
		try {
			Optional<Category> category = categoryRepository.findById(id);

			return category.get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
}
