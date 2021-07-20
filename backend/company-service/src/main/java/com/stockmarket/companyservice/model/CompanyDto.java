package com.stockmarket.companyservice.model;

import java.util.ArrayList;

public class CompanyDto {
    private int id;
    private String name;
    private long turnover;
    private String ceo;
    private String boardOfDirectors;
    private String description;
    private String companyCode;
    private ArrayList<Integer> stockExchangeId;
    private int sectorId;

    public CompanyDto(){
        super();
    }

    public CompanyDto(int id, String name, long turnover, String ceo, String boardOfDirectors, String description, String companyCode, ArrayList<Integer> stockExchangeId, int sectorId) {
        this.id = id;
        this.name = name;
        this.turnover = turnover;
        this.ceo = ceo;
        this.boardOfDirectors = boardOfDirectors;
        this.description = description;
        this.companyCode = companyCode;
        this.stockExchangeId = stockExchangeId;
        this.sectorId = sectorId;
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

    public long getTurnover() {
        return turnover;
    }

    public void setTurnover(long turnover) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public ArrayList<Integer> getStockExchangeId() {
        return stockExchangeId;
    }

    public void setStockExchangeId(ArrayList<Integer> stockExchangeId) {
        this.stockExchangeId = stockExchangeId;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }
}
