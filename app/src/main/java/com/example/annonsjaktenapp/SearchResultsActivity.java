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

/**
 * En aktivitet som visar sökresultat baserat på en sökfråga.
 */
public class SearchResultsActivity extends BaseActivity {

    private EditText searchBar; // Sökfältet för att mata in sökfrågan
    private RecyclerView searchResultsRecyclerView; // RecyclerView för att visa sökresultaten
    private ProductAdapter productAdapter; // Adapter för att binda sökresultaten till RecyclerView
    private List<Product> productList; // Lista över sökresultat

    /* Implementera detta i framtiden*/
    private boolean blocketFilter;
    private boolean traderaFilter;
    private boolean ebayFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        // Sätt upp tillbaka knappen
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        searchBar = findViewById(R.id.search_bar);
        searchResultsRecyclerView = findViewById(R.id.search_results_recycler_view);

        // Initializera produkt listan
        productList = new ArrayList<>();
        setUpBottomNavigation();
        // Sätt upp RecyclerView
        productAdapter = new ProductAdapter(this, productList);
        searchResultsRecyclerView.setAdapter(productAdapter);
        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Hämta sökfrågan från Intent
        Intent intent = getIntent();
        String searchQuery = intent.getStringExtra("search_query");

        // Ange sökfältets text till sökfrågan och sök i produkternas titlar
        searchBar.setText(searchQuery);
        searchProducts(searchQuery);

        // Sätt upp sökfältet för att söka produkter
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

    /**
     * Söker produkter baserat på en sökfråga.
     *
     * @param query Sökfrågan som används för att filtrera produkterna.
     */
    private void searchProducts(String query) {
        // Clear the product list and add matching products
        productList.clear();
        productList.addAll(ProductDatabase.getProducts(query));
        productAdapter.notifyDataSetChanged();
    }
}
