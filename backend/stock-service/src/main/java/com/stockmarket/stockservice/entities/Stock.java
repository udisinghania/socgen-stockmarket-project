package com.stockmarket.stockservice.entities;


import javax.persistence.Id;

public class Stock {
    @Id
    private String id;
    private String companyCode;
    private int stockExchangeId;
    private double price;
    private String date;
    private String time;

    public Stock(){
        super();
    }

    public Stock(String id, String companyCode, int stockExchangeId, double price, String date, String time) {
        super();
        this.id = id;
        this.companyCode = companyCode;
        this.stockExchangeId = stockExchangeId;
        this.price = price;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
