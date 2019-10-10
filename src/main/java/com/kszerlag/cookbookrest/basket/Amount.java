package com.kszerlag.cookbookrest.basket;

import com.kszerlag.cookbookrest.util.Unit;

import javax.validation.constraints.Min;

/**
 * @author kszerlag
 *
 * Defining quantity
 * and units for
 * example 500 grams
 * quantity - 500
 * unit - grams
 */
public class Amount {

    @Min(0)
    private Integer quantity;
    private Unit unit;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
