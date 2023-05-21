package com.example.annonsjaktenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private ProductDataFetchUtil productDataFetchUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Get the category ID from the intent
        int categoryId = getIntent().getIntExtra("categoryId", -1);

        // Create a new ProductDataFetchUtil instance
        productDataFetchUtil = new ProductDataFetchUtil();

        // Get the products for the current category
        List<Product> products = productDataFetchUtil.fetchProductData(this, categoryId);

        // Populate the cardviews with the products for the current category
        for (int i = 1; i <= products.size(); i++) {
            populateCardView(i, products.get(i - 1));
        }
    }

    private void populateCardView(int itemNumber, Product product) {
        CardView cardView = findViewById(getResources().getIdentifier("item" + itemNumber, "id", getPackageName()));
        TextView titleTextView = findViewById(getResources().getIdentifier("item" + itemNumber + "_title", "id", getPackageName()));
        ImageView imageView = findViewById(getResources().getIdentifier("item" + itemNumber + "_image", "id", getPackageName()));

        // set product title and image to the TextView and ImageView
        titleTextView.setText(product.getTitle());
        imageView.setImageResource(product.getImageResId());

        // Set onClickListeners for your CardViews
        cardView.setOnClickListener(v -> {
            Intent intent = new Intent(this, item_detailsActivity.class);
            intent.putExtra("product", product);
            startActivity(intent);
        });
    }

}
