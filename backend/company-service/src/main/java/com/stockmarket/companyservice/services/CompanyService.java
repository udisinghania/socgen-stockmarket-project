package com.stockmarket.companyservice.services;
import com.stockmarket.companyservice.entities.*;
import com.stockmarket.companyservice.repositories.*;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    BodRepository bodRepository;

    @Autowired
    IpoService ipoService;

    @Autowired
    IpoRepository ipoRepository;

    @Autowired
    StockPriceRepository stockPriceRepository;

    @Autowired
    StockPriceService stockPriceService;

    @Autowired
    StockExchangeRepository stockExchangeRepository;


    public List<Company> getAllCompanies()
    {
        return companyRepository.findAll();
    }

    public Company getCompanyById(int id)
    {
        Optional<Company> company = companyRepository.findById(id);

        return company.orElse(null);

    }

    public Company addCompany(Company company)
    {

        return companyRepository.save(company);
    }

    public Boolean deleteById(int id)
    {
        if(companyRepository.findById(id).isPresent())
        {
                List<StockPrice> stocks = stockPriceRepository.findByCompanyId(id);
                if(!stocks.isEmpty())
                {
                    stocks.forEach(stockPrice -> {
                        stockPriceService.deleteByStockId(stockPrice.getId());
                    });
                }
                Optional <Ipo> ipo = Optional.ofNullable(ipoRepository.findByCompanyId(id));
                ipo.ifPresent(value -> ipoRepository.deleteById(value.getId()));
                companyRepository.deleteById(id);
                return true;
        }
        return false;
    }

    public Company updateCompany(int id, Company company)
    {
        Optional<Company> companyOptional = Optional.ofNullable(getCompanyById(id));
        if(companyOptional.isEmpty()) {
            return null;
        }
        company.setId(id);
        return companyRepository.save(company);
    }

    public List<Company> getCompanyByPattern(String pattern)
    {
        return companyRepository.findByNameContainingIgnoreCase(pattern);
    }

    public List<Company> getCompanyByStockExchange(String name)
    {
        return companyRepository.findByStockExchangeNamesContainingIgnoreCase(name);
    }

    public  Boolean updateCompanyForStockExchange(String exchangeName)
    {
        Optional<List<Company>> companyList = Optional.ofNullable(getCompanyByStockExchange(exchangeName));

        List<Company> updatedCompanyList = null;
        if (companyList.isPresent())
        {

            Optional<StockExchange> exchange = stockExchangeRepository.findByName(exchangeName);
            Optional <List<Ipo>> ipos = Optional.ofNullable(ipoRepository.findByStockExchangeId(exchange.get().getId()));
            List<Ipo> ipoList=ipos.get();
            if(!ipoList.isEmpty())
            {
                ipoList.forEach(ipo1->{
                    ipoRepository.deleteById(ipo1.getId());
                });
            }
            List<StockPrice> stocks = stockPriceRepository.findByStockExchangeId(exchange.get().getId());
            if(!stocks.isEmpty())
            {
                stocks.forEach(stockPrice -> {
                    stockPriceService.deleteByStockId(stockPrice.getId());
                    });
            }
            List<Company> c= companyList.get();
            c.forEach(company -> {
            String[] exchange_list = company.getStockExchangeNames().split(",");
            List<String> exchanges = new ArrayList<>(Arrays.asList(exchange_list));
            exchanges.remove(exchangeName);
;            company.setStockExchangeNames(String.join(",",exchanges));
            companyRepository.save(company);
                });
        }
        return true;
    }


}
