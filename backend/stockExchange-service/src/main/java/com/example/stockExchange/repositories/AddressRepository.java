package com.example.stockExchange.repositories;

import com.example.stockExchange.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
