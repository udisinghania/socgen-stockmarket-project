package com.stockmarket.companyservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String companyCode;

    private long turnover;

    private String ceo;

    private String description;

    private int sectorId;

    private String boardOfDirectors;

    private String stockExchangeNames;

    @OneToMany(mappedBy="company")
    @JsonManagedReference
    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    private List<StockPrice> stock_price;


    public Company() {
        super();
    }

    public Company(int id, String name, String companyCode, long turnover, String ceo, String description, int sectorId, String boardOfDirectors, String stockExchangeNames) {
        this.id = id;
        this.name = name;
        this.companyCode = companyCode;
        this.turnover = turnover;
        this.ceo = ceo;
        this.description = description;
        this.sectorId = sectorId;
        this.boardOfDirectors = boardOfDirectors;
        this.stockExchangeNames = stockExchangeNames;
    }

    public String getBoardOfDirectors() {
        return boardOfDirectors;
    }

    public void setBoardOfDirectors(String boardOfDirectors) {
        this.boardOfDirectors = boardOfDirectors;
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

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public String getStockExchangeNames() {
        return stockExchangeNames;
    }

    public void setStockExchangeNames(String stockExchangeNames) {
        this.stockExchangeNames = stockExchangeNames;
    }
}