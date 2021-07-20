package com.stockmarket.excelservice.services;

import com.stockmarket.excelservice.entities.Stock;
import com.stockmarket.excelservice.helper.ExcelHelper;
import com.stockmarket.excelservice.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    StockRepository stockRepository;

    public void save(MultipartFile file) {
        try {
            List<Stock> stocks = ExcelHelper.excelToStocks(file.getInputStream());
            stockRepository.saveAll(stocks);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Stock> getAllStocks() {
        return (List<Stock>) stockRepository.findAll();
    }

}
