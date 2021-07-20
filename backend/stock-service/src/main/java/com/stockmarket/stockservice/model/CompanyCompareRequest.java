package com.stockmarket.stockservice.model;

public class CompanyCompareRequest {
    private String companyCode;
    private int stockExchangeId;
    private String fromPeriod;
    private String toPeriod;
    private String periodicity;

    public CompanyCompareRequest(){
        super();
    }

    public CompanyCompareRequest(String companyCode, int stockExchangeId, String fromPeriod, String toPeriod, String periodicity) {
        this.companyCode = companyCode;
        this.stockExchangeId = stockExchangeId;
        this.fromPeriod = fromPeriod;
        this.toPeriod = toPeriod;
        this.periodicity = periodicity;
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

    public String getFromPeriod() {
        return fromPeriod;
    }

    public void setFromPeriod(String fromPeriod) {
        this.fromPeriod = fromPeriod;
    }

    public String getToPeriod() {
        return toPeriod;
    }

    public void setToPeriod(String toPeriod) {
        this.toPeriod = toPeriod;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }
}
