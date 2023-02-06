package com.example.producto2.model;


import javax.persistence.*;

@Entity
@Table(name= "Tengas")

public class Tenga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String descripcion;

    private double price;

    public Tenga(String name, String descripcion, double price) {
        this.setName(name);
        this.setPrice(price);
        this.setDescripcion(descripcion);
    }

    public Tenga(){

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }

    public void setPrice (double price) { this.price = price; }
}