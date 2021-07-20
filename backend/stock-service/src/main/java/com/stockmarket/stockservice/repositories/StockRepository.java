package com.stockmarket.stockservice.repositories;

import com.stockmarket.stockservice.entities.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock,Integer> {

    List<Stock> findByCompanyCodeAndStockExchangeId(String companyCode, int stockExchangeId);
}
