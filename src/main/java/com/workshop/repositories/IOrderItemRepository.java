package com.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.entities.OrderItem;
import com.workshop.entities.pk.OrderItemPk;

public interface IOrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}
