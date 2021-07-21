package com.stockmarket.companyservice.entities;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="price_per_share")
    private double price;

    @Column(name="total_shares")
    private int shares;

    @Column(name="open_datetime")
    private Timestamp dateTime;

    private String remarks;

    @OneToOne
    private Company company;

    @OneToOne
    private StockExchange stockExchange;

    public Ipo(){
        super();
    }

    public Ipo(int id, double price, int shares, Timestamp dateTime, String remarks, Company company, StockExchange stockExchange) {
        this.id = id;
        this.price = price;
        this.shares = shares;
        this.dateTime = dateTime;
        this.remarks = remarks;
        this.company = company;
        this.stockExchange = stockExchange;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
