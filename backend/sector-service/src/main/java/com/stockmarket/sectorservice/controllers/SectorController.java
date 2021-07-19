package com.stockmarket.sectorservice.controllers;

import com.stockmarket.sectorservice.entities.Sector;
import com.stockmarket.sectorservice.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/sectors")
    private List<Sector> getAllSectors()
    {
        return sectorService.getAllSectors();
    }

    @GetMapping("/sectors/{id}")
    private Sector getSector(@PathVariable("id") int sectorId)
    {
        return sectorService.getSectorById(sectorId);
    }

    @PostMapping("/sectors")
    private int addSector(@RequestBody Sector sector)
    {
        sectorService.addSector(sector);
        return sector.getId();
    }

    @PutMapping("/sectors/{id}")
    private String updateSector(@PathVariable int id, @RequestBody Sector sector){
        sectorService.updateSector(id,sector);
        return "Done";
    }
    @DeleteMapping("/sectors/{id}")
    private void deleteSector(@PathVariable int id){
        sectorService.deleteById(id);
    }

}
