package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class activity_favorite extends BaseActivity {

    private List<FavoriteItem> favoritedItems;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_favorite);
        sharedPreferences = getSharedPreferences("favorites", MODE_PRIVATE);
        favoritedItems = getFavoritedItems();

        RecyclerView itemContainer = findViewById(R.id.favorite_item_container);
        itemContainer.setLayoutManager(new LinearLayoutManager(this));
        itemContainer.setAdapter(new FavoriteItemAdapter(favoritedItems));

        setUpBottomNavigation();
    }

    private List<FavoriteItem> getFavoritedItems() {
        Map<String, FavoriteItem> itemMap = new HashMap<>();
        String[] itemTitles = getResources().getStringArray(R.array.favorite_items);
        String[] itemDescriptions = getResources().getStringArray(R.array.favorite_items_description);
        TypedArray itemImages = getResources().obtainTypedArray(R.array.favorite_item_images);

        for (int i = 1; i <= itemTitles.length; i++) {
            String itemKey = "item" + i;
            boolean isFavorite = sharedPreferences.getBoolean(itemKey, false);
            if (isFavorite) {
                String title = itemTitles[i - 1];
                String description = itemDescriptions[i - 1];
                int imageResId = itemImages.getResourceId(i - 1, -1);
                FavoriteItem item = new FavoriteItem(title, description, imageResId);
                itemMap.put(itemKey, item);
            }
        }
        itemImages.recycle();
        return new ArrayList<>(itemMap.values());
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
