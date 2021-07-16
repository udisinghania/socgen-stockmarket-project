package com.example.stockexchange.repositories;

import com.example.stockexchange.entities.StockExchange;
import org.springframework.data.repository.CrudRepository;

public interface StockExchangeRepository extends CrudRepository<StockExchange, Integer> {



}
