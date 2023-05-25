package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends BaseActivity {

    private EditText searchBar;
    private RecyclerView searchResultsRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private boolean blocketFilter;
    private boolean traderaFilter;
    private boolean sellpyFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        searchBar = findViewById(R.id.search_bar);
        searchResultsRecyclerView = findViewById(R.id.search_results_recycler_view);

        productList = new ArrayList<>();
        setUpBottomNavigation();
        productAdapter = new ProductAdapter(this, productList);
        searchResultsRecyclerView.setAdapter(productAdapter);
        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String searchQuery = intent.getStringExtra("search_query");

        SharedPreferences sharedPref = getSharedPreferences("filter_preferences", Context.MODE_PRIVATE);
        blocketFilter = sharedPref.getBoolean("Blocket", true);
        traderaFilter = sharedPref.getBoolean("Tradera", true);
        sellpyFilter = sharedPref.getBoolean("Sellpy", true);

        searchBar.setText(searchQuery);
        searchProducts(searchQuery);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
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
        List<Product> matchedProducts = new ArrayList<>();

        ProductDataFetchUtil dataFetchUtil = new ProductDataFetchUtil();

        SharedPreferences sharedPref = getSharedPreferences("filter_preferences", Context.MODE_PRIVATE);
        boolean blocket = sharedPref.getBoolean("Blocket", false);
        boolean tradera = sharedPref.getBoolean("Tradera", false);
        boolean sellpy = sharedPref.getBoolean("Sellpy", false);
        boolean anyFilterSelected = blocket || tradera || sellpy;

        // Fetch products from all categories
        for (int categoryId = 0; ; categoryId++) {
            try {
                List<Product> categoryProducts;
                if (anyFilterSelected) {
                    categoryProducts = dataFetchUtil.fetchProductData(this, categoryId, blocket, tradera, sellpy);
                } else {
                    categoryProducts = dataFetchUtil.fetchProductData(this, categoryId);
                }

                for (Product product : categoryProducts) {
                    if (product.getTitle().toLowerCase().contains(query.toLowerCase())) {
                        matchedProducts.add(product);
                    }
                }
            } catch (Resources.NotFoundException e) {

                break;
            }
        }

        // Update the product list with the matching products
        productList.clear();
        productList.addAll(matchedProducts);
        productAdapter.notifyDataSetChanged();
    }

}
