package com.stockmarket.sectorservice.entities;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "sector")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    private String brief;

    @OneToMany(mappedBy="sector")
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private List<Company> companies;

    public List<Company> getCompanies(){
        return companies;
    }

    public Sector(){
        super();
    }

    public Sector(int id, String name, String brief) {
        super();
        this.id = id;
        this.name = name;
        this.brief = brief;
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

    @Override
    public String toString() {

        StringBuilder strb = new StringBuilder("Sector{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brief='" + brief + '\'' +
                '}');
        return strb.toString();
    }
}
