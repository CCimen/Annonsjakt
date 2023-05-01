package com.example.annonsjaktenapp;

import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CategoryActivity extends BaseActivity {
    private SharedPreferences sharedPreferences;

    private String[] productIds = {
            "dator_item1", "dator_item2", "dator_item3", "dator_item4", "dator_item5",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int selectedCategory = getIntent().getIntExtra("selected_category", 1);
        switch (selectedCategory) {
            case 2:
                setContentView(R.layout.skonhet_categoryvy);
                break;
            case 3:
                setContentView(R.layout.mobil_categoryvy);
                break;
            case 4:
                setContentView(R.layout.klader_categoryvy);
                break;
            case 1:
            default:
                setContentView(R.layout.dator_categoryvy);
                break;
        }

        setUpBottomNavigation();

        sharedPreferences = getSharedPreferences("favorites", MODE_PRIVATE);

        setupFavoriteButtonListeners();
        setupItemClickListeners();
        updateFavoriteButtons();
    }

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
                    toggleFavorite(itemId);
                }
            });
        }
    }

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
                    intent.putExtra("category_id", getIntent().getIntExtra("selected_category", 1));
                    intent.putExtra("item_index", index);
                    startActivity(intent);
                }
            });
        }
    }


    private void toggleFavorite(String itemId) {
        boolean currentFavoriteState = sharedPreferences.getBoolean(itemId, false);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(itemId, !currentFavoriteState);
        editor.apply();
        updateFavoriteButtons();
    }

    private void updateFavoriteButton(int buttonId, String preferenceKey) {
        ImageButton favoriteButton = findViewById(buttonId);
        boolean isItemFavorite = sharedPreferences.getBoolean(preferenceKey, false);
        if (isItemFavorite) {
            favoriteButton.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            favoriteButton.setImageResource(android.R.drawable.btn_star);
        }
    }

    private void updateFavoriteButtons() {
        updateFavoriteButton(R.id.favorite_button1, "item1");
        updateFavoriteButton(R.id.favorite_button2, "item2");
        updateFavoriteButton(R.id.favorite_button3, "item3");
        updateFavoriteButton(R.id.favorite_button4, "item4");
        updateFavoriteButton(R.id.favorite_button5, "item5");
    }
}
