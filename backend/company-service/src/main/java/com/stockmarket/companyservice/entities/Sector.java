package com.stockmarket.companyservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String brief;

    @OneToMany(mappedBy = "sector")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Company> companies;

    public Sector() {
        super();
    }

    public Sector(int id, String name, String brief) {
        super();
        this.id = id;
        this.setName(name);
        this.setBrief(brief);
    }


    public int getId() {
        return id;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
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

}