package com.kszerlag.cookbookrest.util;

public enum Unit {

    MILLIGRAMS("milligrams", "mg"),
    GRAMS("grams", "g"),
    KILOGRAMS("kilograms", "kg"),

    MILLILITERS("milliliters", "ml"),
    LITERS("liters", "l"),

    TEASPOONS("Teaspoons", "ts"),
    TABLESPOONS("Spoons", "s"),

    CUP("Cup", "c");


    private String fullName;
    private String shortcutName;

    Unit(String fullName, String shortcutName) {
        this.fullName = fullName;
        this.shortcutName = shortcutName;
    }

    public String getFullName() {
        return fullName;
    }


    public String getShortcutName() {
        return shortcutName;
    }

}
