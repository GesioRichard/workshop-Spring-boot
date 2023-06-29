package com.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.entities.Order;
import com.workshop.repositories.IOrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private IOrderRepository orderRepository;
	
	public Order findById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		
		return order.get();
	}
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
}
