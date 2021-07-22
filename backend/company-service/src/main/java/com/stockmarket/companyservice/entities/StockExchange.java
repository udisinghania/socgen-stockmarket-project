package com.stockmarket.companyservice.entities;

import javax.persistence.*;
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

    @ManyToMany
    @JoinTable(name="company_exchanges",
            joinColumns = @JoinColumn(name = "stock_exchange_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<Company> companies_exchanges;

    public StockExchange() {
        super();
    }

    public StockExchange(int id, String name, String brief, String remarks, Address addressId) {
        super();
        this.id = id;
        this.name = name;
        this.brief = brief;
        this.remarks = remarks;
        this.address = addressId;
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