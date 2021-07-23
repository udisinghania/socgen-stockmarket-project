package com.stockmarket.companyservice.entities;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "companies_exchanges")
    private Set<StockExchange> stockExchanges;

    @ManyToMany(mappedBy = "bod_companies")
    private Set<BoardOfDirectors> bod;

    public Company() {
        super();
    }

    public Company(int id, String name, String companyCode, long turnover, String ceo, String description, int sectorId) {
        this.id = id;
        this.name = name;
        this.companyCode = companyCode;
        this.turnover = turnover;
        this.ceo = ceo;
        this.description = description;
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

    public Set<StockExchange> getStockExchanges() {
        return stockExchanges;
    }

    public void setStockExchanges(Set<StockExchange> stockExchanges) {
        this.stockExchanges = stockExchanges;
    }

    public Set<BoardOfDirectors> getBod() {
        return bod;
    }

    public void setBod(Set<BoardOfDirectors> bod) {
        this.bod = bod;
    }
}