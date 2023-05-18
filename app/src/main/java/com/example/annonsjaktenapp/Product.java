package com.example.annonsjaktenapp;

import java.io.Serializable;
/**
 * En klass som representerar en produkt.
 */
public class Product implements Serializable {
    private final String title; // Produkttitel
    private final String description; // Produktbeskrivning
    private final int imageResId; // Resurs-ID för produktbild
    private final int categoryId; // Kategori-ID för produkten
    private final int itemIndex; // Index för produkten inom kategorin

    /**
     * Skapar en ny instans av Product.
     *
     * @param title       Produkttitel.
     * @param description Produktbeskrivning.
     * @param imageResId  Resurs-ID för produktbild.
     * @param categoryId  Kategori-ID för produkten.
     * @param itemIndex   Index för produkten inom kategorin.
     */
    public Product(String title, String description, int imageResId, int categoryId, int itemIndex) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
        this.categoryId = categoryId;
        this.itemIndex = itemIndex;
    }

    /**
     * Returnerar produkttiteln.
     *
     * @return Produkttitel.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returnerar produktbeskrivningen.
     *
     * @return Produktbeskrivning.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returnerar resurs-ID för produktbild.
     *
     * @return Resurs-ID för produktbild.
     */
    public int getImageResId() {
        return imageResId;
    }

    /**
     * Returnerar kategori-ID för produkten.
     *
     * @return Kategori-ID för produkten.
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Returnerar index för produkten inom kategorin.
     *
     * @return Index för produkten inom kategorin.
     */
    public int getItemIndex() {
        return itemIndex;
    }
}
