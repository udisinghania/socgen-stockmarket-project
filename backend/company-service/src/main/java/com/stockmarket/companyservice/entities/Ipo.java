package com.stockmarket.companyservice.entities;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
public class Ipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="price_per_share")
    private double price;

    @Column(name="total_shares")
    private int shares;


    private Timestamp dateTime;

    private String remarks;

    private int companyId;

    private int stockExchangeId;

    public Ipo(){
        super();
    }

    public Ipo(int id, double price, int shares, Timestamp dateTime, String remarks, int companyId, int stockExchangeId) {
        this.id = id;
        this.price = price;
        this.shares = shares;
        this.dateTime = dateTime;
        this.remarks = remarks;
        this.companyId = companyId;
        this.stockExchangeId = stockExchangeId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getStockExchangeId() {
        return stockExchangeId;
    }

    public void setStockExchangeId(int stockExchangeId) {
        this.stockExchangeId = stockExchangeId;
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


}
