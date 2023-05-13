package com.example.annonsjaktenapp;

import java.io.Serializable;
public class Product implements Serializable {
    private final String title;
    private final String description;
    private final int imageResId;
    private final int categoryId;
    private final int itemIndex;

    public Product(String title, String description, int imageResId, int categoryId, int itemIndex) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
        this.categoryId = categoryId;
        this.itemIndex = itemIndex;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getItemIndex() {
        return itemIndex;
    }
}
