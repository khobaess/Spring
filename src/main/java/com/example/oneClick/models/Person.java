package com.example.oneClick.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя пользователя не должно быть пустым")
    @Column(name ="username")
    private String username;

    @NotEmpty(message = "Email не должен быть пустым")
    @Email(message = "Email неправильного формата")
    @Column(name = "person_email")
    private String email;

    @NotEmpty(message = "Пароль не должен быть пустым")
    @Column(name = "person_password")
    private String password;

    public Person () { }

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
