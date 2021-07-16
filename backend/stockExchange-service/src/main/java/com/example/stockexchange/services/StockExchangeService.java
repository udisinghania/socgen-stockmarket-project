package com.example.stockexchange.services;

import com.example.stockexchange.entities.StockExchange;
import com.example.stockexchange.repositories.AddressRepository;
import com.example.stockexchange.repositories.StockExchangeRepository;
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
        stockExchangeRepository.findAll().forEach(stockExchanges1 -> stockExchanges.add(stockExchanges1));
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
