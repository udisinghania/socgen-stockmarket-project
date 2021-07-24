package com.stockmarket.companyservice.repositories;

import com.stockmarket.companyservice.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchange, Integer> {
    Optional<StockExchange> findByName(String exchange);

}
