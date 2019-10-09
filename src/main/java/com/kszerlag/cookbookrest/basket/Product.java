package com.kszerlag.cookbookrest.basket;

/**
 * @author kszerlag
 *
 * Products which
 * can be added
 * to basket
 */
public class Product {

    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
