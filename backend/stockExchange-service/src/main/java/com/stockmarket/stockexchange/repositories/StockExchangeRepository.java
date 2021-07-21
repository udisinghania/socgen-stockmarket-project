package com.stockmarket.stockexchange.repositories;

import com.stockmarket.stockexchange.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchange, Integer> {


    StockExchange findByName(String stockExchangeName);
}
