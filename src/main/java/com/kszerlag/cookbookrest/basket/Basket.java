package com.kszerlag.cookbookrest.basket;

import com.kszerlag.cookbookrest.util.BaseEntity;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

/**
 * @author kszerlag
 * <p>
 * Contains products
 * intended for
 */
@Entity
class Basket extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "basket", orphanRemoval = true)
    private List<Product> products;

    private Money cost;
    private LocalDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
