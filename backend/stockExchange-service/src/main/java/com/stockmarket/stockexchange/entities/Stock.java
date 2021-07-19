package com.stockmarket.stockexchange.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Stock {

    @Id
    private String id;
    private String companyCode;
    private int companyId;
    private double price;
    private String date;
    private String time;

    @ManyToOne
    private StockExchange stockExchange;

    public Stock(){
        super();
    }

    public Stock(String id, String companyCode, int companyId, double price, String date, String time, StockExchange stockExchange) {
        this.id = id;
        this.companyCode = companyCode;
        this.companyId = companyId;
        this.price = price;
        this.date = date;
        this.time = time;
        this.stockExchange = stockExchange;
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }
}
