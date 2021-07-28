package com.stockmarket.sectorservice.entities;

import javax.persistence.*;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private long turnover;
    private String ceo;
    private String description;
    private String companyCode;
    private String boardOfDirectors;


    private String stockExchangeNames;

    @ManyToOne
    private Sector sector;

    public Company(){
        super();
    }

    public Company(int id, String name, long turnover, String ceo, String description, String companyCode, String stockExchangeNames, String boardOfDirectors, Sector sector) {
        this.id = id;
        this.name = name;
        this.turnover = turnover;
        this.ceo = ceo;
        this.description = description;
        this.companyCode = companyCode;
        this.boardOfDirectors = boardOfDirectors;
        this.sector = sector;
        this.stockExchangeNames=stockExchangeNames;
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

    public String getBoardOfDirectors() {
        return boardOfDirectors;
    }

    public void setBoardOfDirectors(String boardOfDirectors) {
        this.boardOfDirectors = boardOfDirectors;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getStockExchangeNames() {
        return stockExchangeNames;
    }

    public void setStockExchangeNames(String stockExchangeNames) {
        this.stockExchangeNames = stockExchangeNames;
    }
}
