package com.example.annonsjaktenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class HemsidaActivity extends BaseActivity {
    private String[] recommendedProductIds = {"playstation", "macbook", "rakapparat", "sko"};

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

        productImage1.setOnClickListener(v -> showProductDetails(1, 0));
        productImage2.setOnClickListener(v -> showProductDetails(1, 1));
        productImage3.setOnClickListener(v -> showProductDetails(2, 4));
        productImage4.setOnClickListener(v -> showProductDetails(4, 3));

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
    }

    private void showProductDetails(int categoryId, int itemIndex) {
        Intent intent = new Intent(this, item_detailsActivity.class);
        intent.putExtra("category_id", categoryId);
        intent.putExtra("item_index", itemIndex);
        startActivity(intent);
    }
}
