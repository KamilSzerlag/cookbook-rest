package com.kszerlag.cookbookrest.basket;

import com.kszerlag.cookbookrest.recipe.entity.Recipe;

import java.util.List;

public interface BasketService {

    /**
     * Creating new basket
     *
     * @return list containing
     * created baskets
     */
    List<Basket> createNewBasket(String name);

    /**
     * Adding all products from
     * chosen recipe to basket
     *
     * @param recipe
     * @return basket with price and products
     */
    Basket addAllProductsFromRecipe(Recipe recipe, Basket basket);

    /**
     * Fetch Basket
     *
     * @return basket with price and products
     */
    Basket getBasket();

    /**
     * removing all products from
     * basket
     */
    void removeAllProducts();

    /**
     * Adding single product to
     * your basket
     *
     * @param product
     * @param quantity
     * @return basket with price and products
     */
    Basket addProduct(Product product, Integer quantity);

    /**
     * Removing products marked
     * as BOUGHT
     *
     * @return basket with price and products
     */
    Basket removeMarkedAsBoughtProducts();


}
