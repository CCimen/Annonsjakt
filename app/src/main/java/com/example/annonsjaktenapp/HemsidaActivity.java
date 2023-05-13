package com.example.annonsjaktenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class HemsidaActivity extends BaseActivity {
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemsida);

        // Variables for linking the images to the category view
        ImageView categoryImage1 = findViewById(R.id.category_image1);
        ImageView categoryImage2 = findViewById(R.id.category_image2);
        ImageView categoryImage3 = findViewById(R.id.category_image3);
        ImageView categoryImage4 = findViewById(R.id.category_image4);

        // Variables for linking the images to recommended products
        ImageView productImage1 = findViewById(R.id.product_image1);
        ImageView productImage2 = findViewById(R.id.product_image2);
        ImageView productImage3 = findViewById(R.id.product_image3);
        ImageView productImage4 = findViewById(R.id.product_image4);

        // Initialize searchView and filterButton
        searchView = findViewById(R.id.search_view);
        Button filterButton = findViewById(R.id.filter_button);

        List<Product> recommendedProducts = new ArrayList<>();
        recommendedProducts.add(ProductDatabase.getProduct(1, 0)); // Sony Playstation 5 Console
        recommendedProducts.add(ProductDatabase.getProduct(1, 1)); // Apple 2022 MacBook Air Laptop with M2 chip
        recommendedProducts.add(ProductDatabase.getProduct(2, 0)); // Philips Rakapparat
        recommendedProducts.add(ProductDatabase.getProduct(4, 3)); // Adidas Skor

        productImage1.setOnClickListener(v -> showProductDetails(recommendedProducts.get(0)));
        productImage2.setOnClickListener(v -> showProductDetails(recommendedProducts.get(1)));
        productImage3.setOnClickListener(v -> showProductDetails(recommendedProducts.get(2)));
        productImage4.setOnClickListener(v -> showProductDetails(recommendedProducts.get(3)));

        setUpBottomNavigation();

        categoryImage1.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("selected_category", 1);
            startActivity(intent);
        });

        categoryImage2.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("selected_category", 2);
            startActivity(intent);
        });

        categoryImage3.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("selected_category", 3);
            startActivity(intent);
        });

        categoryImage4.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("selected_category", 4);
            startActivity(intent);
        });

        setUpSearchView();

        // Set up the filter button click listener
        filterButton.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, FilterActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    private void showProductDetails(Product product) {
        Intent intent = new Intent(this, SearchResultsActivity.class);
        intent.putExtra("search_query", product.getTitle());
        startActivity(intent);
    }


    private void setUpSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void performSearch(String query) {
        Intent intent = new Intent(HemsidaActivity.this, SearchResultsActivity.class);
        intent.putExtra("search_query", query);
        startActivity(intent);
    }

}

