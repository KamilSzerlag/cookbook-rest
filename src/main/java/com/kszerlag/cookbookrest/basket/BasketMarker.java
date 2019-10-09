package com.kszerlag.cookbookrest.basket;

/**
 * @author kszerlag
 *
 * Markers for
 * products in basket
 * state
 *
 */
public enum BasketMarker {

    TO_BUY("To Buy"),
    BOUGHT("Bought"),
    UNAVAILABLE("Unavailable"),
    MOVE_TO_NEW("Move to new basket");

    private String description;

    BasketMarker(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
