package com.stockmarket.stockservice.model;

public class SectorCompareRequest {

    private String sectorName;
    private String stockExchangeName;
    private String fromPeriod;
    private String toPeriod;
    private String periodicity;

    public SectorCompareRequest(){
        super();
    }

    public SectorCompareRequest(String sectorName, String stockExchangeName, String fromPeriod, String toPeriod, String periodicity) {
        super();
        this.sectorName = sectorName;
        this.stockExchangeName = stockExchangeName;
        this.fromPeriod = fromPeriod;
        this.toPeriod = toPeriod;
        this.periodicity = periodicity;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getStockExchangeName() {
        return stockExchangeName;
    }

    public void setStockExchangeName(String stockExchangeName) {
        this.stockExchangeName = stockExchangeName;
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
