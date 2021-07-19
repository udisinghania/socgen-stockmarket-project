package com.stockmarket.companyservice.repositories;

import com.stockmarket.companyservice.entities.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
    List<Company> findByNameContainingIgnoreCase(String pattern);

}
