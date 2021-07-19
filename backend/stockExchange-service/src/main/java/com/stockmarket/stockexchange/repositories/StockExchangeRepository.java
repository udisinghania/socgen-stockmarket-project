package com.stockmarket.stockexchange.repositories;

import com.stockmarket.stockexchange.entities.StockExchange;
import org.springframework.data.repository.CrudRepository;

public interface StockExchangeRepository extends CrudRepository<StockExchange, Integer> {


    StockExchange findByName(String stockExchangeName);
}
