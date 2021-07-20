package com.stockmarket.companyservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ipo {
    @Id
    private int id;
    private int stockExchangeId;
    private double price;
    private int shares;
    private String openDateTime;
    private String remarks;

    @OneToOne
    private Company company;

    public Ipo(){
        super();
    }

    public Ipo(int id, int stockExchangeId, double price, int shares, String openDateTime, String remarks, Company company) {
        this.id = id;
        this.stockExchangeId = stockExchangeId;
        this.price = price;
        this.shares = shares;
        this.openDateTime = openDateTime;
        this.remarks = remarks;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStockExchangeId() {
        return stockExchangeId;
    }

    public void setStockExchangeId(int stockExchangeId) {
        this.stockExchangeId = stockExchangeId;
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

    public String getOpenDateTime() {
        return openDateTime;
    }

    public void setOpenDateTime(String openDateTime) {
        this.openDateTime = openDateTime;
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
