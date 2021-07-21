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
        return ipoRepository.findAllByOrderByOpenDateTimeAsc();
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

    public Ipo updateIpo(int id, Ipo ipo) {
        Optional<Ipo> ipoOptional = ipoRepository.findById(id);
        if(ipoOptional.isEmpty()) {
            return null;
        }
        ipo.setId(id);
        ipoRepository.save(ipo);
        return ipo;
    }

    public Ipo getIpoByCompanyId(int companyId) {
        return ipoRepository.findByCompanyId(companyId);
    }
}
