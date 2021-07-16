package com.example.sectorservice.services;

import com.example.sectorservice.entities.Sector;
import com.example.sectorservice.repositories.SectorRepository;
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
        List<Sector> sectors = new ArrayList<Sector>();
        sectorRepository.findAll().forEach(sector1 -> sectors.add(sector1));
        return sectors;
    }

    public Sector getSectorById(String id)
    {
        Optional<Sector> sector = sectorRepository.findById(id);
        if(sector.isPresent())
        {
            return sector.get();
        }
        else{
            return new Sector();
        }

    }

    public void addSector(Sector sector)
    {
        sectorRepository.save(sector);
    }

    public void deleteById(String id)
    {
        sectorRepository.deleteById(id);
    }

    public void updateSector(String id, Sector sector)
    {
        Optional<Sector> sector1 = sectorRepository.findById(sector.getId());

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
}
