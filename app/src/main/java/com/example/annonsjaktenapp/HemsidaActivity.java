package com.example.annonsjaktenapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
/**
 * En aktivitetsklass som visar startsidan med kategorier, rekommenderade produkter och sökfunktion.
 */
public class HemsidaActivity extends BaseActivity {
    private SearchView searchView; // Sökvy för att söka efter produkter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemsida);

        // Variables for linking images to category view
        ImageView categoryImage1 = findViewById(R.id.category_image1);
        ImageView categoryImage2 = findViewById(R.id.category_image2);
        ImageView categoryImage3 = findViewById(R.id.category_image3);
        ImageView categoryImage4 = findViewById(R.id.category_image4);

        // Variables for linking images to recommended products
        ImageView productImage1 = findViewById(R.id.product_image1);
        ImageView productImage2 = findViewById(R.id.product_image2);
        ImageView productImage3 = findViewById(R.id.product_image3);
        ImageView productImage4 = findViewById(R.id.product_image4);

        // Initiate searchView and filterButton
        searchView = findViewById(R.id.search_view);

        SharedPreferences sharedPref = getSharedPreferences("filter_preferences", Context.MODE_PRIVATE);
        if (!sharedPref.contains("Blocket") && !sharedPref.contains("Tradera") && !sharedPref.contains("Sellpy")) {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("Blocket", true);
            editor.putBoolean("Tradera", true);
            editor.putBoolean("Sellpy", true);
            editor.apply();
        }
        Button filterButton = findViewById(R.id.filter_button);

        List<Product> recommendedProducts = new ArrayList<>();

        // Fetch recommended products using your utility.
        ProductDataFetchUtil productDataFetchUtil = new ProductDataFetchUtil();

        // Fetch specific products from each category as per your requirements.
        recommendedProducts.add(productDataFetchUtil.fetchProductData(this, 0).get(0)); // category 0, product 0
        recommendedProducts.add(productDataFetchUtil.fetchProductData(this, 0).get(1)); // category 1, product 5
        recommendedProducts.add(productDataFetchUtil.fetchProductData(this, 1).get(4)); // category 1, product 1
        recommendedProducts.add(productDataFetchUtil.fetchProductData(this, 3).get(3)); // category 3, product 4

        productImage1.setOnClickListener(v -> showProductDetails(recommendedProducts.get(0)));
        productImage2.setOnClickListener(v -> showProductDetails(recommendedProducts.get(1)));
        productImage3.setOnClickListener(v -> showProductDetails(recommendedProducts.get(2)));
        productImage4.setOnClickListener(v -> showProductDetails(recommendedProducts.get(3)));

        setUpBottomNavigation();

        categoryImage1.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("categoryId", 0);
            startActivity(intent);
        });

        categoryImage2.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("categoryId", 1);
            startActivity(intent);
        });

        categoryImage3.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("categoryId", 2);
            startActivity(intent);
        });

        categoryImage4.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("categoryId", 3);
            startActivity(intent);
        });

        setUpSearchView();

        // Set up click listener for filter button
        filterButton.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, FilterActivity.class);
            startActivityForResult(intent, 1);
        });
    }


    /**
     * Visar detaljer för en produkt.
     *
     * @param product Produkten vars detaljer ska visas.
     */
    private void showProductDetails(Product product) {
        Intent intent = new Intent(this, SearchResultsActivity.class);
        intent.putExtra("search_query", product.getTitle());
        startActivity(intent);
    }


    /**
     * Ställer in sökvyn och lyssnaren för sökning.
     */
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

    /**
     * Utför sökning med den angivna sökfrågan.
     *
     * @param query Sökfrågan att utföra sökning med.
     */
    private void performSearch(String query) {
        // Retrieve the filter settings
        SharedPreferences sharedPref = getSharedPreferences("filter_preferences", Context.MODE_PRIVATE);
        boolean blocket = sharedPref.getBoolean("Blocket", true);
        boolean tradera = sharedPref.getBoolean("Tradera", true);
        boolean sellpy = sharedPref.getBoolean("Sellpy", true);

        // Now perform the search using the filter settings
        ProductDataFetchUtil productDataFetchUtil = new ProductDataFetchUtil();
        List<Product> products = productDataFetchUtil.fetchProductData(this, 0, blocket, tradera, sellpy);
        // ... do something with the filtered products ...

        Intent intent = new Intent(HemsidaActivity.this, SearchResultsActivity.class);
        intent.putExtra("search_query", query);
        startActivity(intent);
    }


}

