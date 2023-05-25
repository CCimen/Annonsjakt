package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class activity_favorite extends BaseActivity {

    private List<Product> favoritedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_favorite);

        favoritedItems = FavoritesHolder.getInstance().getFavorites();

        RecyclerView itemContainer = findViewById(R.id.favorite_item_container);
        itemContainer.setLayoutManager(new LinearLayoutManager(this));
        itemContainer.setAdapter(new ProductAdapter(this, favoritedItems));

        setUpBottomNavigation();
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
