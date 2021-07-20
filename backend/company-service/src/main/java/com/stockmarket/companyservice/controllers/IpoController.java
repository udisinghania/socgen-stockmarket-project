package com.stockmarket.companyservice.controllers;

import com.stockmarket.companyservice.entities.Company;
import com.stockmarket.companyservice.entities.Ipo;
import com.stockmarket.companyservice.services.IpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ipo")
public class IpoController {

    @Autowired
    IpoService ipoService;

    @GetMapping("/Ipo")
    public ResponseEntity<List<Ipo>> getAllIpos(){
        return ResponseEntity.ok(ipoService.getAllIpos());
    }

    @PostMapping("/Ipo")
    public ResponseEntity<Ipo> addIpo(@RequestBody Ipo ipo){
        return ResponseEntity.ok(ipoService.addIpo(ipo));
    }

    @GetMapping("/ipo/{id}")
    public ResponseEntity getIpoById(@PathVariable("id") int id){
        Optional<Ipo> ipoOptional = Optional.ofNullable(ipoService.getIpoById(id));
        return ipoOptional.isPresent()?ResponseEntity.ok(ipoOptional.get()): ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company with id "+id+" not found.");
    }

    @DeleteMapping("/ipo/{id}")
    private ResponseEntity deleteIpo(@PathVariable int id){

        if (!ipoService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/getIpoByCompany/{companyId}")
    public ResponseEntity getIpoByCompanyId(@PathVariable("companyId") int companyId) {
        Ipo ipo =  ipoService.getIpoByCompanyId(companyId);
        return ipo!=null? ResponseEntity.ok(ipo): ResponseEntity.status(HttpStatus.NOT_FOUND).body("No IPO found with company id "+companyId);
    }

}
