package com.stockmarket.companyservice.controllers;

import com.stockmarket.companyservice.dtos.ExcelDataDto;
import com.stockmarket.companyservice.entities.StockPrice;
import com.stockmarket.companyservice.services.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/company")
public class StockPriceController {

    @Autowired
    public StockPriceService stockPriceService;

    @GetMapping("/StockPrice")
    public ResponseEntity<List<StockPrice>> getStockPrice(){
        return ResponseEntity.ok(stockPriceService.getStockPrice());
    }

    @PostMapping("/StockPrice")
    public ResponseEntity<List<ExcelDataDto>> addStockPrice(@RequestBody List<ExcelDataDto> excelDataDto){
        return ResponseEntity.ok(stockPriceService.addStockPrice(excelDataDto));
    }

    @GetMapping("/StockPrice/companyId/{companyId}/exchangeId/{exchangeId}/fromTime/{fromTime}/toTime/{toTime}")
    public ResponseEntity<List<StockPrice>> getStockPrice(@PathVariable int companyId, @PathVariable int exchangeId, @PathVariable String fromTime, @PathVariable String toTime) throws ParseException {
        return ResponseEntity.ok(stockPriceService.getStockPricesForCompanyComparison(companyId, exchangeId, fromTime, toTime));
    }
}