package com.kszerlag.cookbookrest.recipe.dto;

import com.kszerlag.cookbookrest.recipe.entity.Ingredient;
import com.kszerlag.cookbookrest.util.BaseDto;

import java.util.List;

public class RecipeDto extends BaseDto {
    private String name;
    private List<String> foodCategories;
    private List<IngredientDto> ingredients;
    private Integer cookingTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFoodCategories() {
        return foodCategories;
    }

    public void setFoodCategories(List<String> foodCategories) {
        this.foodCategories = foodCategories;
    }

    public List<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }
}
