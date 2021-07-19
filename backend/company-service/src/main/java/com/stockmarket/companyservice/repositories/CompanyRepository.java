package com.stockmarket.companyservice.repositories;

import com.stockmarket.companyservice.entities.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
}
