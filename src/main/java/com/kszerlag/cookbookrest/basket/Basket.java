package com.kszerlag.cookbookrest.basket;

import java.time.LocalDate;
import java.util.List;

/**
 * @author kszerlag
 */
public class Basket {

    private List<Product> products;
    private Double cost;
    private LocalDate date;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
