package com.stockmarket.companyservice.dtos;

public class CompanyDto {
    private int id;
    private String name;

    private String companyCode;

    private long turnover;

    private String ceo;

    private String description;

    private String boardOfDirectors;

    private int sectorId;

    private String stockExchangeNames;

    public CompanyDto(){
        super();
    }

    public CompanyDto(int id, String name, String companyCode, long turnover, String ceo, String description, String boardOfDirectors, int sectorId, String stockExchangeNames) {
        this.id = id;
        this.name = name;
        this.companyCode = companyCode;
        this.turnover = turnover;
        this.ceo = ceo;
        this.description = description;
        this.boardOfDirectors = boardOfDirectors;
        this.sectorId = sectorId;
        this.stockExchangeNames = stockExchangeNames;
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

    public String getStockExchangeNames() {
        return stockExchangeNames;
    }

    public void setStockExchangeNames(String stockExchangeNames) {
        this.stockExchangeNames = stockExchangeNames;
    }
}
