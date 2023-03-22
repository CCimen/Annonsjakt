package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        int categoryId = getIntent().getIntExtra("category_id", 0);
        loadProducts(categoryId);
    }

    private void loadProducts(int categoryId) {
        // Ladda bilder på produkter baserat på deras kategori id
        // Uppdatera antingen recyclerview eller gridview
        //TODO: Implementera metoden
    }
}