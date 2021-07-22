package com.stockmarket.companyservice.controllers;

import com.stockmarket.companyservice.entities.Stock;
import com.stockmarket.companyservice.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/company")
public class StockController {
    @Autowired
    public StockService stockService;

    @GetMapping("/stocks")
    private ResponseEntity<List<Stock>> getStock(){
        return ResponseEntity.ok(stockService.getStock());
    }

    @PostMapping("/stocks")
    private ResponseEntity<Stock> addStock(@RequestBody Stock stock){
        return ResponseEntity.ok(stockService.addStock(stock));
    }
}
