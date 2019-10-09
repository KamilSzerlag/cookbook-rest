package com.kszerlag.cookbookrest.recipe.entity;

import javax.persistence.Entity;

@Entity
public class FoodImage {

    private String path;
    private Integer width;
    private Long length;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }
}
