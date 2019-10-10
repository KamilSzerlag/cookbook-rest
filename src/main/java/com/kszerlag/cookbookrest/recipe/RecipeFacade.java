package com.kszerlag.cookbookrest.recipe;

import com.kszerlag.cookbookrest.recipe.entity.FoodCategory;
import com.kszerlag.cookbookrest.recipe.entity.Recipe;

import java.util.List;

public interface RecipeFacade {

    Recipe newBlankRecipe(RecipeDto recipeDto);

    Recipe cloneExistingRecipe(Recipe recipe);

    void removeRecipe(Recipe recipe);

    Recipe editRecipe(Recipe recipe);

    List<Recipe> searchRecipe(String name);

    List<Recipe> searchByFoodCategory(List<FoodCategory>);

    List<Recipe> getUserRecipes();

    Recipe randomRecipe();

    Mail sendAsMail();


}
