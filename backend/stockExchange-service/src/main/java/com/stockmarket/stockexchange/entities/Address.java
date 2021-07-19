package com.stockmarket.stockexchange.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String houseNo;
    private String city;
    private String pin;
    private String state;
    private String country;


    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private StockExchange stockExchange;

    public Address(){
        super();
    }

    public Address(int id, String houseNo, String city, String pin, String state, String country, StockExchange stockExchange) {
        super();
        this.id = id;
        this.houseNo = houseNo;
        this.city = city;
        this.pin = pin;
        this.state = state;
        this.country = country;
        this.stockExchange = stockExchange;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    @Override
    public String toString() {

        StringBuilder strb = new StringBuilder("Address{" +
                "id=" + id +
                ", houseNo='" + houseNo + '\'' +
                ", city='" + city + '\'' +
                ", pin='" + pin + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", stockExchange=" + stockExchange +
                '}');
        return strb.toString();
    }
}
