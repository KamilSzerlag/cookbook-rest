package com.kszerlag.cookbookrest.basket;

import com.kszerlag.cookbookrest.util.Purchasable;
import org.joda.money.Money;

/**
 * @author kszerlag
 *
 * Products which
 * can be added
 * to basket
 */
public class Product implements Purchasable {

    private String name;
    private Money price;

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
}
