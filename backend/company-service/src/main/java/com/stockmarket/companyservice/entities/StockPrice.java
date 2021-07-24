package com.stockmarket.companyservice.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StockPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Company company;

    @ManyToOne
    private StockExchange stockExchange;

    private double price;

    private String date;


    public StockPrice() {
        super();
    }

    public StockPrice(int id, Company company, StockExchange stockExchange, double price, String date) {
        this.id = id;
        this.company = company;
        this.stockExchange = stockExchange;
        this.price = price;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }
}