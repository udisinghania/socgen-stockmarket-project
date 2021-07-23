package com.stockmarket.companyservice.services;

import com.stockmarket.companyservice.dtos.CompanyDto;
import com.stockmarket.companyservice.entities.BoardOfDirectors;
import com.stockmarket.companyservice.entities.Company;
import com.stockmarket.companyservice.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;


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
            companyRepository.deleteById(id);
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
        return companyRepository.save(company);
    }

    public List<Company> getCompanyByPattern(String pattern)
    {
        return companyRepository.findByNameContainingIgnoreCase(pattern);
    }

    public List<Company> getCompanyByExchange(int id)
    {
        return companyRepository.findCompanyByExchange(id);
    }

    public Company deactivateCompany(int id)
    {
        Optional<Company> companyOptional = Optional.ofNullable(getCompanyById(id));
        if(companyOptional.isEmpty()) {
            return null;
        }
        companyRepository.deleteById(id);
        return companyOptional.get();
    }


}
