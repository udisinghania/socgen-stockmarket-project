package com.stockmarket.excelservice.dto;

public class ExcelDataDto {

    private int companyId;

    private int exchangeId;

    private double price;

    private String date;

    public ExcelDataDto() {
        super();
    }

    public ExcelDataDto(int companyId, int exchangeId, double price, String date) {
        super();
        this.companyId = companyId;
        this.exchangeId = exchangeId;
        this.price = price;
        this.date = date;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
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
}