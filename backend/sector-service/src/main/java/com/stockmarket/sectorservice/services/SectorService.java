package com.stockmarket.sectorservice.services;

import com.stockmarket.sectorservice.entities.Company;
import com.stockmarket.sectorservice.entities.Sector;
import com.stockmarket.sectorservice.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectorService {


    @Autowired
    SectorRepository sectorRepository;


    public List<Sector> getAllSectors()
    {
        List<Sector> sectors = new ArrayList<>();
        sectorRepository.findAll().forEach(sectors::add);
        return sectors;
    }

    public Sector getSectorById(int id)
    {
        Optional<Sector> sector = sectorRepository.findById(id);
        return sector.orElse(null);

    }

    public Sector getSectorByName(String name)
    {
        Optional<Sector> sector = Optional.ofNullable(sectorRepository.findByName(name));
        return sector.orElse(null);
    }

    public Sector addSector(Sector sector)
    {
        return sectorRepository.save(sector);
    }

    public Boolean deleteById(int id)
    {
        if(sectorRepository.findById(id).isPresent())
        {
            sectorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Sector updateSector(int id, Sector sector)
    {
        Optional<Sector> sector1 = sectorRepository.findById(id);

        if(sector1.isPresent()) {
            Sector newEntity = sector1.get();
            newEntity.setName(sector.getName());
            newEntity.setBrief(sector.getBrief());
            return sectorRepository.save(newEntity);
        }
        else{
            return sectorRepository.save(sector);
        }
    }


    public List<Company> getCompanies(String sectorNme){
        Optional<Sector> sectorOptional = Optional.ofNullable(sectorRepository.findByName(sectorNme));
        return sectorOptional.map(Sector::getCompanies).orElse(null);
    }

    public Sector addCompanyToSector(String sectorName, Company company)
    {
        Sector sector = sectorRepository.findByName(sectorName);
        if(sector == null)
            return null;
        sector.getCompanies().add(company);
        sector = sectorRepository.save(sector);
        return sector;
    }

}
