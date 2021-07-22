package com.stockmarket.stockexchange.controllers;

import com.stockmarket.stockexchange.entities.StockExchange;
import com.stockmarket.stockexchange.services.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/stockexchange")
@CrossOrigin(origins = "http://localhost:4200")
public class StockExchangeController {

    @Autowired
    private StockExchangeService stockExchangeService;


    @GetMapping("/stockexchanges")
    private ResponseEntity<List<StockExchange>> getAllStockExchanges()
    {
        return ResponseEntity.ok(stockExchangeService.getAllStockExchanges());
    }

    @GetMapping("/stockexchanges/{exchangeid}")
    private ResponseEntity getStockExchanges(@PathVariable("exchangeid") int exchangeId)
    {
        if (stockExchangeService.getStockExchangeById(exchangeId)!=null)
        {
            return ResponseEntity.ok(stockExchangeService.getStockExchangeById(exchangeId));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("StockExchange with id "+ exchangeId+" not found.");
        }
    }

    @PostMapping("/stockexchanges")
    private ResponseEntity<StockExchange> saveStockExchange(@RequestBody StockExchange stockExchange)
    {
        return ResponseEntity.ok(stockExchangeService.addStockExchange(stockExchange));
    }

    @PutMapping("/stockexchanges/{id}")
    private ResponseEntity updateSector(@PathVariable int id, @RequestBody StockExchange stockExchange){

        return ResponseEntity.ok(stockExchangeService.updateStockExchange(id,stockExchange));
    }

    @DeleteMapping("/stockexchanges/{id}")
    private ResponseEntity deleteStockExchange(@PathVariable int id){

        if (!stockExchangeService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/stockexchanges/name/{name}")
    private ResponseEntity getStockExchangeByName(@PathVariable("name") String stockExchangeName)
    {
        if (stockExchangeService.getStockExchangeByName(stockExchangeName)!=null)
        {
            return ResponseEntity.ok(stockExchangeService.getStockExchangeByName(stockExchangeName).getId());
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector with name "+ stockExchangeName+" not found.");
        }
    }

    @GetMapping("/companies/{id}")
    private ResponseEntity getCompanies(@PathVariable("id") int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://COMPANY-SERVICE/company/getCompanyByExchange/"+id;
		return restTemplate.getForEntity(url, String.class);
    }


}
