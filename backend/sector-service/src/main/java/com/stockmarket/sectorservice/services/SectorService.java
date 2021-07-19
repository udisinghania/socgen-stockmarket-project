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

    public void addSector(Sector sector)
    {
        sectorRepository.save(sector);
    }

    public void deleteById(int id)
    {
        sectorRepository.deleteById(id);
    }

    public void updateSector(int id, Sector sector)
    {
        Optional<Sector> sector1 = sectorRepository.findById(id);

        if(sector1.isPresent()) {
            Sector newEntity = sector1.get();
            newEntity.setName(sector.getName());
            newEntity.setBrief(sector.getBrief());
            sectorRepository.save(newEntity);
        }
        else{
            sectorRepository.save(sector);
        }
    }

    public List<Company> getCompanies(int id){
        Optional<Sector> sectorOptional = sectorRepository.findById(id);
        return sectorOptional.map(Sector::getCompanies).orElse(null);
    }

    public Sector addCompanyToSector(String sectorName, Company companyDto)
    {
        Sector sector = sectorRepository.findByName(sectorName);
        if(sector == null)
            return null;
        sector.getCompanies().add(companyDto);
        sector = sectorRepository.save(sector);
        return sector;
    }
}
