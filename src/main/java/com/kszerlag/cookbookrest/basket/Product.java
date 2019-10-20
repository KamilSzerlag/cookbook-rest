package com.kszerlag.cookbookrest.basket;

import com.kszerlag.cookbookrest.util.BaseEntity;
import com.kszerlag.cookbookrest.util.Purchasable;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author kszerlag
 *
 * Products which
 * can be added
 * to basket
 */
@Entity
public class Product extends BaseEntity implements Purchasable {

    private String name;
    private Money price;

    @ManyToOne
    private Basket basket;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
