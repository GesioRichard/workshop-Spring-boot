package com.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

}
