package com.workshop.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.entities.Product;
import com.workshop.repositories.IProductRepository;
import com.workshop.service.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private IProductRepository productRepository;
	
	public Product findById(Long id) {
		try {
			Optional<Product> product = productRepository.findById(id);
			
			return product.get();			
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
}
