package com.example.stockExchange.services;

import com.example.stockExchange.entities.StockExchange;
import com.example.stockExchange.repositories.AddressRepository;
import com.example.stockExchange.repositories.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockExchangeService {

    @Autowired
    StockExchangeRepository stockExchangeRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<StockExchange> getAllStockExchanges()
    {
        List<StockExchange> stockExchanges = new ArrayList<StockExchange>();
        stockExchangeRepository.findAll().forEach(books1 -> stockExchanges.add(books1));
        return stockExchanges;
    }

    public StockExchange getStockExchangeById(int id)
    {
        Optional<StockExchange> stockExchange = stockExchangeRepository.findById(id);


        return stockExchange.get();
    }

    public void saveOrUpdate(StockExchange stockExchange)
    {
        stockExchangeRepository.save(stockExchange);
    }


}
