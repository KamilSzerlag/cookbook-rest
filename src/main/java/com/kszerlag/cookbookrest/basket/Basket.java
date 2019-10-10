package com.kszerlag.cookbookrest.basket;

import org.joda.money.Money;

import java.time.LocalDate;
import java.util.List;

/**
 * @author kszerlag
 */
class Basket {

    private List<Product> products;
    private Money cost;
    private LocalDate date;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Money getCost() {
        return cost;
    }

    public void setCost(Money cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
