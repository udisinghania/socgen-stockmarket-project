package com.stockmarket.companyservice.services;

import com.stockmarket.companyservice.entities.Ipo;
import com.stockmarket.companyservice.repositories.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IpoService {

    @Autowired
    IpoRepository ipoRepository;


    public List<Ipo> getAllIpos()
    {
        List<Ipo> ipos = new ArrayList<>();
        ipoRepository.findAll().forEach(ipos::add);
        return ipos;
    }

    public Ipo getIpoById(int id)
    {
        Optional<Ipo> ipo = ipoRepository.findById(id);
        return ipo.orElse(null);

    }

    public Ipo addIpo(Ipo ipo)
    {
        return ipoRepository.save(ipo);
    }

    public Boolean deleteById(int id)
    {
        if(ipoRepository.findById(id).isPresent())
        {
            ipoRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Ipo getIpoByCompanyId(int companyId) {
        return ipoRepository.findByCompanyId(companyId);
    }
}
