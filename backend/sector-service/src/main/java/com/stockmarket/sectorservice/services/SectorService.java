package com.stockmarket.sectorservice.services;

import com.stockmarket.sectorservice.entities.Company;
import com.stockmarket.sectorservice.entities.Sector;
import com.stockmarket.sectorservice.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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
            //deleting all the companies listed in sector
            String sectorName= sectorRepository.findById(id).get().getName();
            List<Company> companyList = getCompanies(sectorName);

            RestTemplate restTemplate = new RestTemplate();
            if (!companyList.isEmpty())
            {
                companyList.forEach(
                        company -> {
                            String url = "http://localhost:9191/company/company/{id}";
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("id", String.valueOf(company.getId()));
                            restTemplate.delete ( url,  params );
                        });
            }
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


}
