package com.kszerlag.cookbookrest.recipe.entity;

import com.kszerlag.cookbookrest.util.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class FoodImage extends BaseEntity {

    @OneToOne
    private Recipe recipe;

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
