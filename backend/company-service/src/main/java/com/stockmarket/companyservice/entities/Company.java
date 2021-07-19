package com.stockmarket.companyservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private long turnover;
    private String ceo;
    private String boardOfDirectors;
    private String description;
    private String companyCode;
    private int stockExchangeId;
    private int sectorId;

    @OneToMany
    @JsonProperty(access= JsonProperty.Access.READ_WRITE)
    private List<Ipo> ipos;

    @OneToMany
    @JsonProperty(access= JsonProperty.Access.READ_WRITE)
    private List<Stock> stocks;

    public List<Stock> getStocks(){
        return stocks;
    }

    public List<Ipo> getIpos(){
        return ipos;
    }

    public Company(){
        super();
    }

    public Company(String id, String name, long turnover, String ceo, String boardOfDirectors, String description, String companyCode, int stockExchangeId, int sectorId, List<Ipo> ipos, List<Stock> stocks) {
        super();
        this.id = id;
        this.name = name;
        this.turnover = turnover;
        this.ceo = ceo;
        this.boardOfDirectors = boardOfDirectors;
        this.description = description;
        this.companyCode = companyCode;
        this.stockExchangeId = stockExchangeId;
        this.sectorId = sectorId;
        this.ipos = ipos;
        this.stocks = stocks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
