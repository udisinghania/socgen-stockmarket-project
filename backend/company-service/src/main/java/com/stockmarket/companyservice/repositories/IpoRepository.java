package com.stockmarket.companyservice.repositories;

import com.stockmarket.companyservice.entities.Ipo;
import org.springframework.data.repository.CrudRepository;

public interface IpoRepository extends CrudRepository<Ipo, Integer> {
}
