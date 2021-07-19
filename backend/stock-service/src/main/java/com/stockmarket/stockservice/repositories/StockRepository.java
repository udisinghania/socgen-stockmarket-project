package com.stockmarket.stockservice.repositories;

import com.stockmarket.stockservice.entities.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock,Integer> {
    List<Stock> findByCompanyCodeAndStockExchangeName(String companyCode, String stockExchangeName);
}
