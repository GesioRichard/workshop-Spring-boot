package com.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
