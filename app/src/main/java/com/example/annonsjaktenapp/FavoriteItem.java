package com.example.annonsjaktenapp;
/**
 * En modellklass som representerar ett favoritobjekt.
 */
public class FavoriteItem {
    private final String title;
    private final String description;
    private final int imageResId;

    /**
     * Skapar en instans av FavoriteItem.
     *
     * @param title       Titel för favoritobjektet.
     * @param description Beskrivning för favoritobjektet.
     * @param imageResId  Resurs-ID för bild för favoritobjektet.
     */
    public FavoriteItem(String title, String description, int imageResId) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
    }

    /**
     * Returnerar titeln för favoritobjektet.
     *
     * @return Titeln för favoritobjektet.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returnerar beskrivningen för favoritobjektet.
     *
     * @return Beskrivningen för favoritobjektet.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returnerar resurs-ID för bild för favoritobjektet.
     *
     * @return Resurs-ID för bild för favoritobjektet.
     */
    public int getImageResId() {
        return imageResId;
    }
}

