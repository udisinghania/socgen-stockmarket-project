package com.stockmarket.companyservice.services;

import com.stockmarket.companyservice.dtos.ExcelDataDto;
import com.stockmarket.companyservice.entities.StockPrice;
import com.stockmarket.companyservice.repositories.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockPriceService {

    @Autowired
    public StockPriceRepository stockPriceRepository;

    public List<StockPrice> getStockPrice(){
        return stockPriceRepository.findAll();
    }

    public List<ExcelDataDto> addStockPrice(List<ExcelDataDto> excelDataDto) {
        List<ExcelDataDto> failedInserts = new ArrayList<>();
        for(ExcelDataDto excelData: excelDataDto) {
            try {
                stockPriceRepository.addStockPrice(excelData.getCompanyId(), excelData.getExchangeId(), excelData.getPrice(), excelData.getTimestamp());
            }
            catch(Exception e) {
                failedInserts.add(excelData);
            }
        }
        return failedInserts;
    }

    public List<StockPrice> getStockPrice(int companyId, int stockId, String fromTime, String toTime){
        return stockPriceRepository.getStockPriceList(companyId, stockId, fromTime, toTime);
    }
}
