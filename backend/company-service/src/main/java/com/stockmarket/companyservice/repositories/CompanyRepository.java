package com.stockmarket.companyservice.repositories;

import com.stockmarket.companyservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    List<Company> findByNameContainingIgnoreCase(String pattern);


    List<Company>  findByStockExchangeNamesContainingIgnoreCase(String title);



}
