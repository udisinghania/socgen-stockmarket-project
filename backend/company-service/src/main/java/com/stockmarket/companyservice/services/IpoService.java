package com.stockmarket.companyservice.services;

import com.stockmarket.companyservice.entities.Ipo;
import com.stockmarket.companyservice.repositories.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IpoService {

    @Autowired
    IpoRepository ipoRepository;


    public List<Ipo> getAllIpos()
    {
        return ipoRepository.findAllByOrderByDateTimeAsc();
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
        ipo.setId(id);
        Optional<Ipo> ipoOptional = Optional.ofNullable(getIpoById(id));
        if(ipoOptional.isEmpty()) {
            return null;
        }
        return ipoRepository.save(ipo);
    }

    public Ipo getIpoByCompanyId(int companyId) {
        return ipoRepository.findByCompanyId(companyId);
    }

    public List<Ipo> getIposByStockExchangeId(int stockExchangeId) {
        return ipoRepository.findByStockExchangeId(stockExchangeId);
    }

}
