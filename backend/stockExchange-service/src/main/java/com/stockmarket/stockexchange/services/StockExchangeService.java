package com.stockmarket.stockexchange.services;

import com.stockmarket.stockexchange.entities.Address;
import com.stockmarket.stockexchange.entities.StockExchange;
import com.stockmarket.stockexchange.repositories.AddressRepository;
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

    @Autowired
    AddressRepository addressRepository;

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
        Optional<Address> address = addressRepository.findById(id);
        if(stockExchange1.isPresent() && address.isPresent()) {
            StockExchange newEntity = stockExchange1.get();
            Address address1 = address.get();
            newEntity.setName(stockExchange.getName());
            newEntity.setBrief(stockExchange.getBrief());
            newEntity.setRemarks(stockExchange.getRemarks());
            address1.setHouseNo(stockExchange.getAddress().getHouseNo());
            address1.setPin(stockExchange.getAddress().getPin());
            address1.setCity(stockExchange.getAddress().getCity());
            address1.setState(stockExchange.getAddress().getState());
            address1.setCountry(stockExchange.getAddress().getCountry());
            newEntity.setAddress(address1);
            newEntity = stockExchangeRepository.save(newEntity);
            return newEntity;
        }
        else{
            return stockExchangeRepository.save(stockExchange);
        }
    }


    public StockExchange getStockExchangeByName(String name)
    {
        Optional<StockExchange> stockExchange = Optional.ofNullable(stockExchangeRepository.findByName(name));
        return stockExchange.orElse(null);
    }


}
