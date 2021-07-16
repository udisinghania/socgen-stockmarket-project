package com.example.stockexchange.controllers;

import com.example.stockexchange.entities.StockExchange;
import com.example.stockexchange.services.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockExchange")
public class StockExchangeController {

    @Autowired
    private StockExchangeService stockExchangeService;

    @GetMapping("/stockexchanges")
    private List<StockExchange> getAllStockExchanges()
    {
        return stockExchangeService.getAllStockExchanges();
    }

    @GetMapping("/stockexchanges/{exchangeid}")
    private StockExchange getStockExchanges(@PathVariable("exchangeid") int exchangeId)
    {
        return stockExchangeService.getStockExchangeById(exchangeId);
    }

    @PostMapping("/stockexchanges")
    private int saveStockExchange(@RequestBody StockExchange stockExchange)
    {
        stockExchangeService.saveOrUpdate(stockExchange);
        return stockExchange.getId();
    }


}
