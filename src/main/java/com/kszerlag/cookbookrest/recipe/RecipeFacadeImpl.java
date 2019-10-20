package com.kszerlag.cookbookrest.recipe;

import com.kszerlag.cookbookrest.recipe.entity.FoodCategory;
import com.kszerlag.cookbookrest.recipe.entity.Recipe;
import com.kszerlag.cookbookrest.textreader.OcrUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class RecipeFacadeImpl implements RecipeFacade {

    private RecipeRepository recipeRepository;

    public RecipeFacadeImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe saveNewRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe cloneExistingRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public Recipe findRecipeById(Long id) throws NoSuchElementException {
        return recipeRepository.findById(id).get();
    }

    @Override
    public void removeRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe editRecipe(Long id) {
        //Recipe recipe = recipeRepository.findById(id);
        return null;
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> findByName(String name) {
        return recipeRepository.findByNameLike(name);
    }

    @Override
    public List<Recipe> findByFoodCategories(List<FoodCategory> foodCategories) {
        return recipeRepository.findByFoodCategories(foodCategories);
    }

    @Override
    public List<Recipe> getUserRecipes() {
        return null;
    }

    @Override
    public Recipe getRandomRecipe() {
        List<Recipe> recipes = recipeRepository.findAll();
        if (CollectionUtils.isEmpty(recipes)) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(recipes.size() - 1);
        return recipes.get(randomIndex);
    }

    @Override
    public String recognizeRecipeDescription(File file, BufferedImage bufferedImage) {
        if (file != null) {
            return OcrUtil.getINSTANCE().recognizeTextTessFromBufferedImage(file);
        }
        if (bufferedImage != null) {
            return OcrUtil.getINSTANCE().recognizeTextTessFromBufferedImage(bufferedImage);
        }
        return null;
    }
}
