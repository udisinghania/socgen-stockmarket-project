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


}
