package com.kszerlag.cookbookrest.recipe;

import com.kszerlag.cookbookrest.recipe.dto.RecipeDto;
import com.kszerlag.cookbookrest.recipe.entity.FoodCategory;
import com.kszerlag.cookbookrest.recipe.entity.Recipe;
import com.kszerlag.cookbookrest.recipe.mapper.RecipeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    protected Logger logger = LoggerFactory.getLogger(RecipeController.class);

    private static String IMG_FILE_SUFFIX = "img-recipe-";

    private RecipeFacade recipeFacade;

    @Value("${app.upload.folder}")
    private String uploadDirectory;

    public RecipeController(RecipeFacade recipeFacade) {
        this.recipeFacade = recipeFacade;
    }

    @PostMapping
    private ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto) {
        try {
            Recipe recipe = RecipeMapper.INSTANCE.toRecipeEntity(recipeDto);
            recipe = recipeFacade.saveNewRecipe(recipe);
            RecipeDto createdRecipeDto = RecipeMapper.INSTANCE.toRecipeDto(recipe);
            return new ResponseEntity<>(recipeDto, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @GetMapping("/{recipeId}")
    private ResponseEntity<RecipeDto> getRecipeById(@PathVariable(required = true) Long recipeId) {
        try {
            Recipe recipe = recipeFacade.findRecipeById(recipeId);
            RecipeDto recipeDto = RecipeMapper.INSTANCE.toRecipeDto(recipe);
            return new ResponseEntity<>(recipeDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            logger.debug(e.getMessage());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<RecipeDto>> getAllRecipes() {
        try {
            List<Recipe> recipes = recipeFacade.findAll();
            List<RecipeDto> recipeDtos = RecipeMapper.INSTANCE.toRecipeDtoList(recipes);
            return new ResponseEntity<>(recipeDtos, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @GetMapping("/categories")
    private ResponseEntity<List<RecipeDto>> getRecipesByCategory(@PathVariable(required = true) String[] categories) {
        try {
            List<String> foodCategoriesList = Arrays.asList(categories);
            List<FoodCategory> foodCategories = RecipeMapper.INSTANCE.toFoodCategoryEnumList(foodCategoriesList);
            List<Recipe> recipes = recipeFacade.findByFoodCategories(foodCategories);
            List<RecipeDto> recipeDtos = RecipeMapper.INSTANCE.toRecipeDtoList(recipes);
            return new ResponseEntity<>(recipeDtos, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
     }

     @GetMapping("/random")
     private ResponseEntity<RecipeDto> getRandomRecipe() {
        try {
            Recipe randomRecipe = recipeFacade.getRandomRecipe();
            RecipeDto randomRecipeDto = RecipeMapper.INSTANCE.toRecipeDto(randomRecipe);
            return new ResponseEntity<>(randomRecipeDto, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
     }

    @DeleteMapping("/{recipeId}")
    private ResponseEntity deleteRecipe(@PathVariable Long recipeId) {
        try {
            recipeFacade.removeRecipe(recipeId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @PostMapping(value = "/image/{recipeId}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    private ResponseEntity uploadFoodImage(@PathVariable Long recipeId, @RequestParam(name = "file") MultipartFile uploadedFile) {
        try {
            String fileName = IMG_FILE_SUFFIX + recipeId;
            String filePath = uploadDirectory + "/" + fileName;

            Files.copy(uploadedFile.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/image/{recipeId}", produces = {MediaType.IMAGE_PNG_VALUE})
    private ResponseEntity<byte[]> downloadFoodImage(@PathVariable Long recipeId) {
        String fileName = IMG_FILE_SUFFIX + recipeId;
        String filePath = uploadDirectory + "/" + fileName;
        try {
            return new ResponseEntity<>(Files.readAllBytes(Paths.get(filePath)), HttpStatus.ACCEPTED);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
}
