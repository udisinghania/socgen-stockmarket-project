package com.stockmarket.companyservice.services;

import com.stockmarket.companyservice.entities.Stock;
import com.stockmarket.companyservice.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    public StockRepository stockRepository;

    public List<Stock> getStock(){
        return stockRepository.findAll();
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }
}
