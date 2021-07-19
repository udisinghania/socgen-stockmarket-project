package com.stockmarket.stockexchange.repositories;

import com.stockmarket.stockexchange.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
