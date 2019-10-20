package com.kszerlag.cookbookrest.recipe;

import com.kszerlag.cookbookrest.recipe.entity.FoodCategory;
import com.kszerlag.cookbookrest.recipe.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByNameLike(String name);

    Recipe findByCookingTimeIsLessThanEqual(Integer maxCookingTime);

    List<Recipe> findByFoodCategories(List<FoodCategory> categories);

}
