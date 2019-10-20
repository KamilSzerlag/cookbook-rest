package com.kszerlag.cookbookrest.recipe.entity;

import com.kszerlag.cookbookrest.util.BaseEntity;

import javax.persistence.*;
import java.util.Iterator;
import java.util.Set;

@Entity
public class Recipe extends BaseEntity {

    @Column(unique = true,
            nullable = false)
    private String name;

    @OneToOne(mappedBy = "recipe")
    private FoodImage foodImage;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = FoodCategory.class)
    private Set<FoodCategory> foodCategories;

    @OneToMany(mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    @Column(nullable = false)
    private Integer cookingTime; //cooking time in minutes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodImage getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(FoodImage foodImage) {
        this.foodImage = foodImage;
    }

    public Set<FoodCategory> getFoodCategories() {
        return foodCategories;
    }

    public void setFoodCategories(Set<FoodCategory> foodCategories) {
        this.foodCategories = foodCategories;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Ingredient> addIngredient(Ingredient ingredient) {
        if (ingredients != null) {
            boolean isAdded = ingredients.add(ingredient);
            if (!isAdded) {
                for (Iterator<Ingredient> iterator = ingredients.iterator(); iterator.hasNext(); ) {
                    Ingredient next = iterator.next();
                    if (next.equals(ingredient)) {
                        Double quantity = ingredient.getQuantity();
                        quantity += 1.0d;
                        return ingredients;
                    }
                }
            }
        }
        return ingredients;
    }
}
