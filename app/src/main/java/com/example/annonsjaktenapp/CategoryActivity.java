package com.example.annonsjaktenapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private ProductDataFetchUtil productDataFetchUtil;

    private static final String PREFS_NAME = "com.example.annonsjaktenapp.favorites";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Visa tillbaka-knappen i verktygsfältet

        int categoryId = getIntent().getIntExtra("categoryId", -1);

        productDataFetchUtil = new ProductDataFetchUtil();

        List<Product> products = productDataFetchUtil.fetchProductData(this, categoryId);

        for (int i = 1; i <= products.size(); i++) {
            populateCardView(i, products.get(i - 1));
        }
    }

    private void populateCardView(int itemNumber, Product product) {
        CardView cardView = findViewById(getResources().getIdentifier("item" + itemNumber, "id", getPackageName()));
        TextView titleTextView = findViewById(getResources().getIdentifier("item" + itemNumber + "_title", "id", getPackageName()));
        ImageView imageView = findViewById(getResources().getIdentifier("item" + itemNumber + "_image", "id", getPackageName()));

        titleTextView.setText(product.getTitle());
        imageView.setImageResource(product.getImageResId());

        cardView.setOnClickListener(v -> {
            Intent intent = new Intent(this, item_detailsActivity.class);
            intent.putExtra("product", product);
            startActivity(intent);
        });

        ImageButton favoriteButton = findViewById(getResources().getIdentifier("favorite_button" + itemNumber, "id", getPackageName()));

        updateFavoriteButtonImage(product, favoriteButton);

        favoriteButton.setOnClickListener(v -> {
            toggleFavoriteProduct(product);
            updateFavoriteButtonImage(product, favoriteButton);
        });
    }

    private void updateFavoriteButtonImage(Product product, ImageButton favoriteButton) {
        if (FavoritesHolder.getInstance().isFavorite(product)) {
            favoriteButton.setImageResource(R.drawable.btn_star_big_on);
        } else {
            favoriteButton.setImageResource(R.drawable.btn_star_big_off);
        }
    }

    private void toggleFavoriteProduct(Product product) {
        FavoritesHolder favoritesHolder = FavoritesHolder.getInstance();

        if (favoritesHolder.isFavorite(product)) {
            favoritesHolder.removeFavorite(product);
            removeFromFavoritesInPrefs(product.getTitle());
        } else {
            favoritesHolder.addFavorite(product);
            addToFavoritesInPrefs(product.getTitle());
        }
    }

    private void addToFavoritesInPrefs(String title) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String favorites = prefs.getString("favorites", "");

        // Append the new favorite title
        favorites += title + ",";

        // Save the new favorites string
        prefs.edit().putString("favorites", favorites).apply();
    }

    private void removeFromFavoritesInPrefs(String title) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String favorites = prefs.getString("favorites", "");

        // Remove the favorite title
        favorites = favorites.replace(title + ",", "");

        // Save the new favorites string
        prefs.edit().putString("favorites", favorites).apply();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
