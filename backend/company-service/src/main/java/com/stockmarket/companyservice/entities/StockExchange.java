package com.stockmarket.companyservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="STOCK_EXCHANGE")
public class StockExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String brief;
    private String remarks;

    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;

    @OneToMany(mappedBy="stockExchange")
    @JsonManagedReference
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private List<StockPrice> stock_price;

    public List<StockPrice> getStocks(){
        return stock_price;
    }


    public StockExchange() {
        super();
    }

    public StockExchange(int id, String name, String brief, String remarks, Address address) {
        this.id = id;
        this.name = name;
        this.brief = brief;
        this.remarks = remarks;
        this.address = address;
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}