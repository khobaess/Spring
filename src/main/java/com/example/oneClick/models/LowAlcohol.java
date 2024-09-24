package com.example.oneClick.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "lowalcohol")
public class LowAlcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lowalcohol_id")
    private int id;

    @NotEmpty
    @Column(name = "lowalcohol_name")
    private String name;

    @NotEmpty
    @Column(name = "lowalcohol_description")
    private String description;

    @Column(name = "lowalcohol_photo")
    private String photo;

    @NotEmpty
    @Column(name = "lowalcohol_price")
    private int price;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
