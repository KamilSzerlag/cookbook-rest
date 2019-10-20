package com.kszerlag.cookbookrest.recipe;

import com.kszerlag.cookbookrest.recipe.entity.FoodCategory;
import com.kszerlag.cookbookrest.recipe.entity.Recipe;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public interface RecipeFacade {

    Recipe saveNewRecipe(Recipe recipe);

    Recipe cloneExistingRecipe(Recipe recipe);

    Recipe findRecipeById(Long id);

    void removeRecipe(Long id);

    Recipe editRecipe(Long id);

    List<Recipe> findAll();

    List<Recipe> findByName(String name);

    List<Recipe> findByFoodCategories(List<FoodCategory> foodCategories);

    List<Recipe> getUserRecipes();

    Recipe getRandomRecipe();

    String recognizeRecipeDescription(File file, BufferedImage bufferedImage);
}
