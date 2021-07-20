package com.stockmarket.companyservice.services;

import com.stockmarket.companyservice.entities.Company;
import com.stockmarket.companyservice.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;


    public List<Company> getAllCompanies()
    {
        List<Company> companies = new ArrayList<>();
        companyRepository.findAll().forEach(companies::add);
        return companies;
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
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Company updateCompany(int id, Company company)
    {
        Optional<Company> company1 = companyRepository.findById(id);

        if(company1.isPresent()) {
            Company newEntity = company1.get();
            newEntity.setName(company.getName());
            newEntity.setCompanyCode(company.getCompanyCode());
            newEntity.setCeo(company.getCeo());
            newEntity.setSectorId(company.getSectorId());
            newEntity.setDescription(company.getDescription());
            newEntity.setTurnover(company.getTurnover());
            newEntity.setStockExchangeId(company.getStockExchangeId());
            newEntity.setBoardOfDirectors(company.getBoardOfDirectors());
            return companyRepository.save(newEntity);
        }
        else{
            return companyRepository.save(company);
        }
    }

    public List<Company> getCompanyByPattern(String pattern){
        return companyRepository.findByNameContainingIgnoreCase(pattern);
    }



}
