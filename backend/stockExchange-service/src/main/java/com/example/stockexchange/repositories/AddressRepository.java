package com.example.stockexchange.repositories;

import com.example.stockexchange.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
