package com.stockmarket.stockservice.controllers;


import com.stockmarket.stockservice.entities.Stock;
import com.stockmarket.stockservice.model.CompanyCompareRequest;
import com.stockmarket.stockservice.model.SectorCompareRequest;
import com.stockmarket.stockservice.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getAllStocks(){
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock){
        return ResponseEntity.ok(stockService.addStock(stock));
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity getStockById(@PathVariable("id") String id){
        Optional<Stock> stockOptional = Optional.ofNullable(stockService.getStockById(id));
        return stockOptional.isPresent()?ResponseEntity.ok(stockOptional.get()): ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stock with id "+id+" not found.");
    }

    @DeleteMapping("/stocks/{id}")
    private ResponseEntity deleteStock(@PathVariable String id){

        if (!stockService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/stocks/compareSector")
    private ResponseEntity<?> compareStocksBySector(@RequestBody SectorCompareRequest compareRequest){
        List<Stock> stockPrices = null;
        try {
            stockPrices = stockService.getStockPricesForSector(compareRequest);
        } catch (ParseException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid Date Format");
        }
        return ResponseEntity.ok(stockPrices);
    }

    @GetMapping("/stocks/compareCompany")
    private ResponseEntity<?> compareStocksByCompany(@RequestBody CompanyCompareRequest compareRequest){
        List<Stock> stockPrices = null;
        try {
            stockPrices = stockService.getStockPricesForCompany(compareRequest);
        } catch (ParseException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid Date Format");
        }
        return ResponseEntity.ok(stockPrices);
    }



}
