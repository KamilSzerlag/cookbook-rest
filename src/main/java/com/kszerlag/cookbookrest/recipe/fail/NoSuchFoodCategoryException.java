package com.kszerlag.cookbookrest.recipe.fail;

public class NoSuchFoodCategoryException extends RuntimeException {

    private static final String MSG_CONTENT = "No such food category like: ";

    public NoSuchFoodCategoryException(String category) {
        super(MSG_CONTENT + category);
    }
}
