package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity {

    private EditText searchBar;
    private RecyclerView searchResultsRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    private boolean blocketFilter;
    private boolean traderaFilter;
    private boolean ebayFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        // Set up the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        searchBar = findViewById(R.id.search_bar);
        searchResultsRecyclerView = findViewById(R.id.search_results_recycler_view);

        // Initialize the product list
        productList = new ArrayList<>();

        // Set up the RecyclerView
        productAdapter = new ProductAdapter(this, productList);
        searchResultsRecyclerView.setAdapter(productAdapter);
        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve the search query from the Intent
        Intent intent = getIntent();
        String searchQuery = intent.getStringExtra("search_query");

        // Set the search bar's text to the query and search the products
        searchBar.setText(searchQuery);
        searchProducts(searchQuery);

        // Set up the search bar
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Search the products whenever the text changes
                searchProducts(s.toString());
            }
        });
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

    private void searchProducts(String query) {
        // Clear the product list and add matching products
        productList.clear();
        productList.addAll(ProductDatabase.getProducts(query));
        productAdapter.notifyDataSetChanged();
    }
}
