package com.stockmarket.companyservice.dtos;


public class ExcelDataDto {

    private String companyCode;

    private String stockExchangeName;


    private double price;

    private String date;

    public ExcelDataDto() {
        super();
    }

    public ExcelDataDto(String companyCode, String stockExchangeName, double price, String date) {
        this.companyCode = companyCode;
        this.stockExchangeName = stockExchangeName;
        this.price = price;
        this.date = date;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getStockExchangeName() {
        return stockExchangeName;
    }

    public void setStockExchangeName(String stockExchangeName) {
        this.stockExchangeName = stockExchangeName;
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