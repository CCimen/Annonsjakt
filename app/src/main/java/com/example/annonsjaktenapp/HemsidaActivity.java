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
/**
 * En aktivitetsklass som visar startsidan med kategorier, rekommenderade produkter och sökfunktion.
 */
public class HemsidaActivity extends BaseActivity {
    private SearchView searchView; // Sökvy för att söka efter produkter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemsida);

        // Variabler för att länka bilderna till kategorivisning
        ImageView categoryImage1 = findViewById(R.id.category_image1);
        ImageView categoryImage2 = findViewById(R.id.category_image2);
        ImageView categoryImage3 = findViewById(R.id.category_image3);
        ImageView categoryImage4 = findViewById(R.id.category_image4);

        // Variabler för att länka bilderna till rekommenderade produkter
        ImageView productImage1 = findViewById(R.id.product_image1);
        ImageView productImage2 = findViewById(R.id.product_image2);
        ImageView productImage3 = findViewById(R.id.product_image3);
        ImageView productImage4 = findViewById(R.id.product_image4);

        // Initiera searchView och filterButton
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

        // Ställ in klicklyssnare för filterknappen
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
        Intent intent = new Intent(HemsidaActivity.this, SearchResultsActivity.class);
        intent.putExtra("search_query", query);
        startActivity(intent);
    }

}

