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
}
