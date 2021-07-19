package com.stockmarket.stockservice.services;

import com.stockmarket.stockservice.entities.Stock;
import com.stockmarket.stockservice.model.Company;
import com.stockmarket.stockservice.model.CompanyCompareRequest;
import com.stockmarket.stockservice.model.SectorCompareRequest;
import com.stockmarket.stockservice.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public List<Stock> getAllStocks()
    {
        List<Stock> stocks = new ArrayList<>();
        stockRepository.findAll().forEach(stocks::add);
        return stocks;
    }

    public Stock getStockById(int id)
    {
        Optional<Stock> stock = stockRepository.findById(id);
        return stock.orElse(null);

    }

    public Stock addStock(Stock stock)
    {

        return stockRepository.save(stock);
    }

    public Boolean deleteById(int id)
    {
        if(stockRepository.findById(id).isPresent())
        {
            stockRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Stock> getStockPricesForCompany(CompanyCompareRequest compareRequest) throws ParseException {
        Date fromDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getFromPeriod());
        Date toDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getToPeriod());

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:9090/stockExchanges/stockExchange";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/"+compareRequest.getStockExchangeName(), String.class);

        List<Stock> stockPrices = stockRepository
                .findByCompanyCodeAndStockExchangeName(compareRequest.getCompanyCode(), compareRequest.getStockExchangeName());


        return new ArrayList<Stock>();
    }

    public List<Stock> getStockPricesForSector(SectorCompareRequest compareRequest) throws ParseException{
        Date fromDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getFromPeriod());
        Date toDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getToPeriod());
        List<Stock> stockPricesForSector = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:9091/sector/companies";
        ResponseEntity<Company[]> response = restTemplate.getForEntity(fooResourceUrl + "/"+compareRequest.getSectorName(), Company[].class);
        Company[] companies = response.getBody();




        return new ArrayList<Stock>();
    }
}
