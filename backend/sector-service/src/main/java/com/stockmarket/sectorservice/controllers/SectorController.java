package com.stockmarket.sectorservice.controllers;

import com.stockmarket.sectorservice.entities.Company;
import com.stockmarket.sectorservice.entities.Sector;
import com.stockmarket.sectorservice.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/sectors")
    private ResponseEntity<List<Sector>> getAllSectors(){
        return ResponseEntity.ok(sectorService.getAllSectors());
    }

    @GetMapping("/sectors/{id}")
    private ResponseEntity getSector(@PathVariable("id") int sectorId)
    {
        if (sectorService.getSectorById(sectorId)!=null)
        {
            return ResponseEntity.ok(sectorService.getSectorById(sectorId));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector with id "+ sectorId+" not found.");
        }
    }

    @PostMapping("/sectors")
    private ResponseEntity<Sector> addSector(@RequestBody Sector sector)
    {
        return ResponseEntity.ok(sectorService.addSector(sector));
    }

    @PutMapping("/sectors/{id}")
    private ResponseEntity updateSector(@PathVariable int id, @RequestBody Sector sector){

        return ResponseEntity.ok(sectorService.updateSector(id,sector));
    }

    @DeleteMapping("/sectors/{id}")
    private ResponseEntity deleteSector(@PathVariable int id){

        if (!sectorService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/companies/{id}")
    private ResponseEntity<List<Company>> getCompanies(@PathVariable("id") int id){
        return ResponseEntity.ok(sectorService.getCompanies(id));
    }

}
