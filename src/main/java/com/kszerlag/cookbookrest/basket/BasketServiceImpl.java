package com.kszerlag.cookbookrest.basket;

import com.kszerlag.cookbookrest.recipe.entity.Recipe;

import java.util.List;

public class BasketServiceImpl implements BasketService {

    @Override
    public List<Basket> createNewBasket(String name) {
        return null;
    }

    @Override
    public Basket addAllProductsFromRecipe(Recipe recipe, Basket basket) {
        return null;
    }

    @Override
    public Basket getBasket() {
        return null;
    }

    @Override
    public void removeAllProducts() {

    }

    @Override
    public Basket addProduct(Product product, Integer quantity) {
        return null;
    }

    @Override
    public Basket removeMarkedAsBoughtProducts() {
        return null;
    }
}
