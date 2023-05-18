package com.example.annonsjaktenapp;

import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

/**
 * En aktivitetsklass som visar produkter inom en specifik kategori.
 */
public class CategoryActivity extends BaseActivity {
    private SharedPreferences sharedPreferences;

    private String[] productIds = {
            "dator_item1", "dator_item2", "dator_item3", "dator_item4", "dator_item5",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int selectedCategory = getIntent().getIntExtra("selected_category", 1);
        switch (selectedCategory) {
            case 2:
                setContentView(R.layout.skonhet_categoryvy); // Visar layouten för skönhetskategorin
                break;
            case 3:
                setContentView(R.layout.mobil_categoryvy); // Visar layouten för mobilkategorin
                break;
            case 4:
                setContentView(R.layout.klader_categoryvy); // Visar layouten för klädkategorin
                break;
            case 1:
            default:
                setContentView(R.layout.dator_categoryvy); // Visar layouten för datorkategorin
                break;
        }

        setUpBottomNavigation(); // Ställer in navigeringsmenyn i botten av skärmen

        sharedPreferences = getSharedPreferences("favorites", MODE_PRIVATE);

        setupFavoriteButtonListeners(); // Ställer in lyssnare för favoritknappar
        setupItemClickListeners(); // Ställer in lyssnare för produktobjekten
        updateFavoriteButtons(); // Uppdaterar favoritknapparnas tillstånd
    }

    /**
     * Ställer in lyssnare för favoritknapparna.
     */
    private void setupFavoriteButtonListeners() {
        int[] favoriteButtonIds = new int[]{
                R.id.favorite_button1,
                R.id.favorite_button2,
                R.id.favorite_button3,
                R.id.favorite_button4,
                R.id.favorite_button5
        };

        for (int i = 0; i < favoriteButtonIds.length; i++) {
            final int buttonId = favoriteButtonIds[i];
            final String itemId = "item" + (i + 1);

            ImageButton favoriteButton = findViewById(buttonId);
            favoriteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toggleFavorite(itemId); // Växlar favoritstatus för objektet
                }
            });
        }
    }

    /**
     * Ställer in lyssnare för produktobjekten.
     */
    private void setupItemClickListeners() {
        int[] itemIds = new int[]{
                R.id.item1,
                R.id.item2,
                R.id.item3,
                R.id.item4,
                R.id.item5
        };

        for (int i = 0; i < itemIds.length; i++) {
            final int index = i;
            CardView item = findViewById(itemIds[index]);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CategoryActivity.this, item_detailsActivity.class);
                    int categoryId = getIntent().getIntExtra("selected_category", 1);
                    Product product = ProductDatabase.getProduct(categoryId, index);
                    intent.putExtra("product", product);
                    startActivity(intent);
                }
            });
        }
    }


    /**
     * Växlar favoritstatus för ett objekt baserat på dess ID.
     *
     * @param itemId ID för objektet.
     */
    private void toggleFavorite(String itemId) {
        boolean currentFavoriteState = sharedPreferences.getBoolean(itemId, false);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(itemId, !currentFavoriteState);
        editor.apply();
        updateFavoriteButtons();
    }

    /**
     * Uppdaterar favoritknappen för ett specifikt objekt baserat på preferensnyckeln.
     *
     * @param buttonId       ID för favoritknappen.
     * @param preferenceKey  Nyckel för SharedPreferences-preferensen för objektet.
     */
    private void updateFavoriteButton(int buttonId, String preferenceKey) {
        ImageButton favoriteButton = findViewById(buttonId);
        boolean isItemFavorite = sharedPreferences.getBoolean(preferenceKey, false);
        if (isItemFavorite) {
            favoriteButton.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            favoriteButton.setImageResource(android.R.drawable.btn_star);
        }
    }

    /**
     * Uppdaterar favoritknapparna för alla objekt.
     */
    private void updateFavoriteButtons() {
        updateFavoriteButton(R.id.favorite_button1, "item1");
        updateFavoriteButton(R.id.favorite_button2, "item2");
        updateFavoriteButton(R.id.favorite_button3, "item3");
        updateFavoriteButton(R.id.favorite_button4, "item4");
        updateFavoriteButton(R.id.favorite_button5, "item5");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed(); // Går tillbaka till föregående aktivitet när hemknappen klickas
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
