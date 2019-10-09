package com.kszerlag.cookbookrest.recipe.entity;

import com.kszerlag.cookbookrest.util.Tag;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Recipe {

    private FoodImage foodImage;
    private List<FoodCategory> foodCategories;
    private List<Ingredient> ingredients;
    private List<Tag> tags;

    public FoodImage getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(FoodImage foodImage) {
        this.foodImage = foodImage;
    }

    public List<FoodCategory> getFoodCategories() {
        return foodCategories;
    }

    public void setFoodCategories(List<FoodCategory> foodCategories) {
        this.foodCategories = foodCategories;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> addIngredient(Ingredient ingredient) {
        if (ingredients != null)
            ingredients.add(ingredient);
        return ingredients;
    }

    public List<FoodCategory> addFoodCategory(FoodCategory foodCategory) {
        if (foodCategories != null)
            foodCategories.add(foodCategory);
        return foodCategories;
    }

}
