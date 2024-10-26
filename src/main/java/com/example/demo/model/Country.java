package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_country")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;    

    @Column(name="capital")
    private String capital;

    @Column(name="continent")
    private String continent;

    @Column(name="population")
    private Integer population;

    @Column(name="area")
    private Integer area;

    @Column(name="gdp_per_capita")
    private Integer gdpPerCapita;

    @Column(name="year")
    private Integer year;

}
