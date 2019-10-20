package com.kszerlag.cookbookrest.recipe.entity;

import com.kszerlag.cookbookrest.recipe.fail.NoSuchFoodCategoryException;

import java.util.NoSuchElementException;

public enum FoodCategory {
    DESSERT("Dessert"),
    MEAT("Meat"),
    DAIRY_PRODUCTS("Dairy products"),
    NUTS("Nuts"),
    BREADS("Breads"),
    SPICES("Spices"),
    FISH_SEAFOOD("Fish/Seafood"),
    CANDIES("Candies"),
    SNACK("Snack"),
    STARTER("Starter");


    private String type;

    FoodCategory(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static FoodCategory from(String s) {
        for (FoodCategory category : FoodCategory.values()) {
            if (category.getType().equals(s))
                return category;
        }
        throw new NoSuchFoodCategoryException(s);
    }
}
