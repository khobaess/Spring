package com.example.oneClick.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "champagne")
public class Champagne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "champagne_id")
    private int id;

    @NotEmpty
    @Column(name = "champagne_name")
    private String name;
    @NotEmpty
    @Column(name = "champagne_description")
    private String description;
    @Column(name = "champagne_photo")
    private String photo;
    @NotEmpty
    @Column(name = "champagne_price")
    private int price;



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




    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
