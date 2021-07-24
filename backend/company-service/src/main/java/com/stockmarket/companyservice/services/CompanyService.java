package com.stockmarket.companyservice.services;
import com.stockmarket.companyservice.entities.*;
import com.stockmarket.companyservice.repositories.BodRepository;
import com.stockmarket.companyservice.repositories.CompanyRepository;
import com.stockmarket.companyservice.repositories.IpoRepository;
import com.stockmarket.companyservice.repositories.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    BodRepository bodRepository;

    @Autowired
    IpoRepository ipoRepository;

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
            Ipo ipo = ipoRepository.findByCompanyId(id);
            companyRepository.deleteById(id);
            ipoRepository.deleteById(ipo.getId());
            return true;
        }
        return false;
    }

    public Company updateCompany(int id, Company company)
    {
        company.setId(id);
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

    


}
