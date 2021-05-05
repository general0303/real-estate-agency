package com.company.Entitys;

import javax.persistence.*;

@Entity
@Table(name = "housings")
public class Housing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Column(name="type", length = 10, nullable = false)
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Column(name="price", length = 10, nullable = false)
    private Integer price;

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    @Column(name="number_of_rooms", length = 3, nullable = false)
    private Integer numberOfRooms;

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }


    @Column(name="square", length = 4, nullable = false)
    private Integer square;

    public void setSquare(Integer square) {
        this.square = square;
    }

    public Integer getSquare() {
        return square;
    }

    @Column(name="nearest_metro", length = 25, nullable = false)
    private String nearestMetro;

    public void setNearestMetro(String nearestMetro) {
        this.nearestMetro = nearestMetro;
    }

    public String getNearestMetro() {
        return nearestMetro;
    }

    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Column(name="image", length = 150, nullable = false)
    private String image;

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
