package com.example.annonsjaktenapp;

import java.util.ArrayList;
import java.util.List;

public class FavoritesHolder {
    private static final FavoritesHolder ourInstance = new FavoritesHolder();

    public static FavoritesHolder getInstance() {
        return ourInstance;
    }

    private final List<Product> favorites;

    private FavoritesHolder() {
        this.favorites = new ArrayList<>();
    }

    public void addFavorite(Product product) {
        if (!favorites.contains(product)) {
            favorites.add(product);
        }
    }

    public void removeFavorite(Product product) {
        favorites.remove(product);
    }

    public boolean isFavorite(Product product) {
        return favorites.contains(product);
    }

    public List<Product> getFavorites() {
        return new ArrayList<>(favorites);
    }
}
