package com.stockmarket.stockexchange.entities;
import javax.persistence.*;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private long turnover;
    private String ceo;
    private String description;
    private String companyCode;
    private String boardOfDirectors;
    private int sectorId;

    @ManyToOne
    private StockExchange stockExchange;

    public Company(){
        super();
    }

    public Company(int id, String name, long turnover, String ceo, String description, String companyCode, String boardOfDirectors, int sectorId, StockExchange stockExchange) {
        this.id = id;
        this.name = name;
        this.turnover = turnover;
        this.ceo = ceo;
        this.description = description;
        this.companyCode = companyCode;
        this.boardOfDirectors = boardOfDirectors;
        this.sectorId = sectorId;
        this.stockExchange = stockExchange;
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

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }
}
