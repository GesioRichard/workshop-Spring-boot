package com.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.entities.Order;

public interface IOrderRepository extends JpaRepository<Order, Long> {

}
