package com.kszerlag.cookbookrest.recipe.entity;

import com.kszerlag.cookbookrest.basket.Product;

import javax.persistence.Entity;

@Entity
public class Ingredient extends Product {

    private Long calories;
    private Product substitute;
    private Double quantity;

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    public Product getSubstitute() {
        return substitute;
    }

    public void setSubstitute(Product substitute) {
        this.substitute = substitute;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
