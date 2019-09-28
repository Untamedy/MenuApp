/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Lenovo
 */
@Entity
public class Dish implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private double weight;  
    @Column
    private double price;
    @Column(name = "sale")
    private boolean sale;
    @Column
    private String name;

    public Dish() {
    }

    public Dish(int id, String name, double weight, double price, boolean withSale) {
        this.id = id;
        this.weight = weight;
        this.price = price;
        this.sale = withSale;
        this.name = name;
    }

    public Dish(String name, double weight, double price, boolean withSale) {
        this.weight = weight;
        this.price = price;
        this.sale = withSale;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isWithSale() {
        return sale;
    }

    public void setWithSale(boolean withSale) {
        this.sale = withSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
}
