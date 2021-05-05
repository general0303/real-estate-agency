package com.company.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Column(name="district", length = 15, nullable = false)
    private String district;

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrict() {
        return district;
    }

    @Column(name="street", length = 15, nullable = false)
    private String street;

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    @Column(name="number_of_house", length = 3, nullable = false)
    private Integer numberOfHouse;

    public void setNumberOfHouse(Integer numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public Integer getNumberOfHouse() {
        return numberOfHouse;
    }

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Housing> housings;

    public void setHousings(List<Housing> housings) {
        this.housings = housings;
    }

    public List<Housing> getHousings() {
        return housings;
    }

    @Column(name="map", length = 1000, nullable = false)
    private String map;

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
