package com.example.annonsjaktenapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class activity_favorite extends BaseActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        sharedPreferences = getSharedPreferences("favorites", MODE_PRIVATE);

        List<String> favoritedItems = getFavoritedItems();

        // Populate the view with the favorited items
        setUpBottomNavigation();
    }

    private List<String> getFavoritedItems() {
        List<String> favoritedItems = new ArrayList<>();
        for (int i = 1; i <= 40; i++) {
            String itemKey = "item" + i;
            boolean isFavorite = sharedPreferences.getBoolean(itemKey, false);
            if (isFavorite) {
                favoritedItems.add(itemKey);
            }
        }
        return favoritedItems;
    }
}
