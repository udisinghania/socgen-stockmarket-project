package com.stockmarket.stockexchange.services;

import com.stockmarket.stockexchange.entities.Company;
import com.stockmarket.stockexchange.entities.StockExchange;
import com.stockmarket.stockexchange.repositories.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockExchangeService {

    @Autowired
    StockExchangeRepository stockExchangeRepository;

    public List<StockExchange> getAllStockExchanges()
    {
        List<StockExchange> stockExchanges = new ArrayList<>();
        stockExchangeRepository.findAll().forEach(stockExchanges::add);
        return stockExchanges;
    }

    public StockExchange getStockExchangeById(int id)
    {
        Optional<StockExchange> stockExchange = stockExchangeRepository.findById(id);


        return stockExchange.orElse(null);
    }

    public StockExchange addStockExchange(StockExchange stockExchange)
    {
        return stockExchangeRepository.save(stockExchange);
    }

    public Boolean deleteById(int id)
    {
        if(stockExchangeRepository.findById(id).isPresent())
        {
            stockExchangeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public StockExchange updateStockExchange(int id, StockExchange stockExchange)
    {
        Optional<StockExchange> stockExchange1 = stockExchangeRepository.findById(id);

        if(stockExchange1.isPresent()) {
            StockExchange newEntity = stockExchange1.get();
            newEntity.setName(stockExchange.getName());
            newEntity.setBrief(stockExchange.getBrief());
            newEntity.setRemarks(stockExchange.getRemarks());
            newEntity.setAddress(stockExchange.getAddress());
            return stockExchangeRepository.save(newEntity);
        }
        else{
            return stockExchangeRepository.save(stockExchange);
        }
    }

    public List<Company> getCompanies(int id){
        Optional<StockExchange> stockExchangeOptional = stockExchangeRepository.findById(id);
        return stockExchangeOptional.map(StockExchange::getCompanies).orElse(null);
    }

    public StockExchange addCompanyToStockExchange(String stockExchangeName, Company companyDto)
    {
        StockExchange stockExchange = stockExchangeRepository.findByName(stockExchangeName);
        if(stockExchange == null)
            return null;
        stockExchange.getCompanies().add(companyDto);
        stockExchange = stockExchangeRepository.save(stockExchange);
        return stockExchange;
    }

}
