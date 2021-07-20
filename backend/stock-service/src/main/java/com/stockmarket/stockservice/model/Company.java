package com.stockmarket.stockservice.model;

public class Company {

    private int id;
    private String name;
    private String companyCode;
    private String turnover;
    private String ceo;
    private String boardOfDirectors;
    private int stockExchangeId;
    private int sectorId;
    private String description;

    public Company(){
        super();
    }

    public Company(int id, String name, String companyCode, String turnover, String ceo, String boardOfDirectors, int stockExchangeId, int sectorId, String description) {
        this.id = id;
        this.name = name;
        this.companyCode = companyCode;
        this.turnover = turnover;
        this.ceo = ceo;
        this.boardOfDirectors = boardOfDirectors;
        this.stockExchangeId = stockExchangeId;
        this.sectorId = sectorId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getBoardOfDirectors() {
        return boardOfDirectors;
    }

    public void setBoardOfDirectors(String boardOfDirectors) {
        this.boardOfDirectors = boardOfDirectors;
    }

    public int getStockExchangeId() {
        return stockExchangeId;
    }

    public void setStockExchangeId(int stockExchangeId) {
        this.stockExchangeId = stockExchangeId;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
