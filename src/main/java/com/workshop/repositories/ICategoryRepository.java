package com.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.entities.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
