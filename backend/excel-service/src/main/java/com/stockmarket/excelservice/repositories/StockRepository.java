package com.stockmarket.excelservice.repositories;

import com.stockmarket.excelservice.entities.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Integer> {
}
