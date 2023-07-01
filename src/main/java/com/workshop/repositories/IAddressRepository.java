package com.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.entities.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {

}
