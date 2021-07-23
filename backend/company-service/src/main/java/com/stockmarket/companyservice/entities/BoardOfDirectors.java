package com.stockmarket.companyservice.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class BoardOfDirectors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name="bod_company",
    joinColumns = @JoinColumn(name = "board_of_director_id"),
    inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<Company> bod_companies;

    public BoardOfDirectors(){

    }

    public BoardOfDirectors(int id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<Company> getBod_companies() {
        return bod_companies;
    }

    public void setBod_companies(Set<Company> bod_companies) {
        this.bod_companies = bod_companies;
    }
}
