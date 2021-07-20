package com.stockmarket.excelservice.services;

import com.stockmarket.excelservice.dto.StockDto;
import com.stockmarket.excelservice.entities.Stock;
import com.stockmarket.excelservice.helper.ExcelHelper;
import com.stockmarket.excelservice.repositories.StockRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    StockRepository stockRepository;

    public void save(MultipartFile file) {

        List<Stock> stockPriceList = new ArrayList<Stock>();

        try {
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet worksheet = workbook.getSheetAt(0);
            int i=1;
            Iterator<Row> rows = worksheet.iterator();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                StockDto stockPriceDto = new StockDto();

                stockPriceDto.setCompanyCode(String.valueOf(currentRow.getCell(0).getStringCellValue()));
                stockPriceDto.setStockExchangeId(7);
                stockPriceDto.setPrice((float) currentRow.getCell(2).getNumericCellValue());
                stockPriceDto.setDate((currentRow.getCell(3).getDateCellValue()).toString());
                stockPriceDto.setTime(currentRow.getCell(4).getStringCellValue());

                    stockPriceList.add(dtoToEntity(stockPriceDto));

            }

        } catch(Throwable e) {
            e.printStackTrace();
        }

        List<StockDto> stockPriceDtoList = new ArrayList<StockDto>();

        this.stockRepository.saveAll(stockPriceList);
    }

    public List<Stock> getAllStocks() {
        return (List<Stock>) stockRepository.findAll();
    }

    public Stock dtoToEntity(StockDto stockPriceDto) {
        Stock stockPrice = new Stock();
        stockPrice.setId(stockPriceDto.getId());
        stockPrice.setPrice(stockPriceDto.getPrice());
        stockPrice.setDate(stockPriceDto.getDate());
        stockPrice.setTime(stockPriceDto.getTime());
        stockPrice.setCompanyCode(stockPriceDto.getCompanyCode());
        stockPrice.setStockExchangeId(stockPriceDto.getStockExchangeId());

        return stockPrice;
    }

    public StockDto entityToDto(Stock stockPrice) {
        StockDto stockPriceDto = new StockDto();
        stockPriceDto.setId(stockPrice.getId());
        stockPriceDto.setPrice(stockPrice.getPrice());
        stockPriceDto.setDate(stockPrice.getDate());
        stockPriceDto.setTime(stockPrice.getTime());
        stockPriceDto.setCompanyCode(stockPrice.getCompanyCode());
        stockPriceDto.setStockExchangeId(stockPrice.getStockExchangeId());

        return stockPriceDto;
    }

}
