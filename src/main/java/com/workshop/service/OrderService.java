package com.workshop.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.entities.Order;
import com.workshop.repositories.IOrderRepository;
import com.workshop.service.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private IOrderRepository orderRepository;

	public Order findById(Long id) {
		try {
			Optional<Order> order = orderRepository.findById(id);

			return order.get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}
}
