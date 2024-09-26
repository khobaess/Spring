package com.example.oneClick.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "strongalcohol")
public class StrongAlcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "имя не должен быть пустым")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "описание не должен быть пустым")
    @Column(name = "description")
    private String description;

    @NotEmpty(message = "фото не должен быть пустым")
    @Column(name = "photo")
    private String photo;

    @Min(value = 1, message = "Цена должна быть неотрицательной и больше 0")
    @Column(name = "price")
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
