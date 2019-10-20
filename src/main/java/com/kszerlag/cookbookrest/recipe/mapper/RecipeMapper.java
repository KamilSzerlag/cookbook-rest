package com.kszerlag.cookbookrest.recipe.mapper;

import com.kszerlag.cookbookrest.recipe.RecipeRepository;
import com.kszerlag.cookbookrest.recipe.dto.IngredientDto;
import com.kszerlag.cookbookrest.recipe.dto.RecipeDto;
import com.kszerlag.cookbookrest.recipe.entity.FoodCategory;
import com.kszerlag.cookbookrest.recipe.entity.Ingredient;
import com.kszerlag.cookbookrest.recipe.entity.Recipe;
import org.mapstruct.Context;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDto toRecipeDto(Recipe recipe);

    Recipe toRecipeEntity(RecipeDto recipeDto);

    @IterableMapping(elementTargetType = RecipeDto.class)
    List<RecipeDto> toRecipeDtoList(List<Recipe> recipes);

    @IterableMapping(elementTargetType = Recipe.class)
    List<Recipe> toRecipeEntity(List<RecipeDto> recipeDtos, @Context RecipeRepository repo);

    IngredientDto toIngredientDto(Ingredient ingredient);

    Ingredient toIngredientEntity(IngredientDto ingredientDto, @Context RecipeRepository repo);

    default String toFoodCategoryString(FoodCategory category) {
        return category.getType();
    }

    default FoodCategory toFoodCategoryEnum(String category) {
        return FoodCategory.valueOf(category);
    }

    default List<String> toFoodCategoriesString(List<FoodCategory> foodCategories) {
        if (foodCategories == null) {
            return null;
        }
        List<String> foodCategoriesStrings = new ArrayList<>();
        for (FoodCategory category : foodCategories) {
            foodCategoriesStrings.add(category.getType());
        }
        return foodCategoriesStrings;
    }

    List<FoodCategory> toFoodCategoryEnumList(List<String> foodCategoriesStrings);
}
