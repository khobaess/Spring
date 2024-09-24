package com.example.oneClick.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "energetic")
public class Energetic {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Empty name")
    @Column(name = "product_name")
    private String name;

    @NotEmpty(message = "Empty description")
    @Column(name = "product_description")
    private String description;

    @NotEmpty(message = "Empty photo")
    @Column(name = "product_photo")
    private String photo;

    @Min(value = 1, message = "Price must be greater than zero")
    @Column(name = "product_price")
    private int price;


    public Energetic() { }

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
