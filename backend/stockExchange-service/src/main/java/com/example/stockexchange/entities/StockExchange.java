package com.example.stockexchange.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "stockExchange")
public class StockExchange {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    private String name;
    private String brief;
    private String remarks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JsonManagedReference
    private Address address;

    public StockExchange() {

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

    @Override
    public String toString() {
        return "StockExchange{" +
                "id=" + id +
                ", brief='" + brief + '\'' +
                ", remarks='" + remarks + '\'' +
                ", name=" + name +
                ", address=" + address +
                '}';
    }
}
