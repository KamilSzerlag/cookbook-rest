package com.kszerlag.cookbookrest.caloriecalculator;

import com.kszerlag.cookbookrest.recipe.entity.Ingredient;
import com.kszerlag.cookbookrest.recipe.entity.Recipe;

import java.util.Optional;
import java.util.Set;

/**
 * @author kszerlag
 * <p>
 * Calories calculator
 */
public class CalCalculator {

    public long calculateRecipeCalories(Recipe recipe) {
        Set<Ingredient> ingredients = Optional.ofNullable(recipe)
                .map(Recipe::getIngredients)
                .get();
        return ingredients.stream()
                .mapToLong(Ingredient::getCalories)
                .sum();
    }
}
