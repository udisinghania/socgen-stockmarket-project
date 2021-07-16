package com.example.sectorservice.controllers;

import com.example.sectorservice.entities.Sector;
import com.example.sectorservice.services.SectorService;
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
    private Sector getSector(@PathVariable("id") String sectorId)
    {
        return sectorService.getSectorById(sectorId);
    }

    @PostMapping("/sectors")
    private String addSector(@RequestBody Sector sector)
    {
        sectorService.addSector(sector);
        return sector.getId();
    }

    @PutMapping("/sectors/{id}")
    private String updateSector(@PathVariable String id, @RequestBody Sector sector){
        sectorService.updateSector(id,sector);
        return "Done";
    }
    @DeleteMapping("/sectors/{id}")
    private void deleteSector(@PathVariable String id){
        sectorService.deleteById(id);
    }

}
