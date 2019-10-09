package com.kszerlag.cookbookrest.recipe.entity;

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

}
