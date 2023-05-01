package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HemsidaActivity extends BaseActivity {
    private String[] recommendedProductIds = {"playstation", "macbook", "rakapparat", "sko"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemsida);

        // Variabler för att länka bilderna till kategorivyn
        ImageView categoryImage1 = findViewById(R.id.category_image1);
        ImageView categoryImage2 = findViewById(R.id.category_image2);
        ImageView categoryImage3 = findViewById(R.id.category_image3);
        ImageView categoryImage4 = findViewById(R.id.category_image4);

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

        // Variabler för att länka bilderna till annonsvyn
        ImageView productImage1 = findViewById(R.id.product_image1);
        ImageView productImage2 = findViewById(R.id.product_image2);
        ImageView productImage3 = findViewById(R.id.product_image3);
        ImageView productImage4 = findViewById(R.id.product_image4);

        productImage1.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, AnnonsvyActivity.class);
            intent.putExtra("product_image_resource", R.drawable.product_image1);
            startActivity(intent);
        });

        productImage2.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, AnnonsvyActivity.class);
            intent.putExtra("product_image_resource", R.drawable.product_image2);
            startActivity(intent);
        });

        productImage3.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, AnnonsvyActivity.class);
            intent.putExtra("product_image_resource", R.drawable.product_image3);
            startActivity(intent);
        });

        productImage4.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, AnnonsvyActivity.class);
            intent.putExtra("product_image_resource", R.drawable.product_image4);
            startActivity(intent);
        });

        // OnClickListener för rekommenderade produkter
        View.OnClickListener productClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = -1;
                switch (v.getId()) {
                    case R.id.product_image1:
                        index = 0;
                        break;
                    case R.id.product_image2:
                        index = 1;
                        break;
                    case R.id.product_image3:
                        index = 2;
                        break;
                    case R.id.product_image4:
                        index = 3;
                        break;
                }
                if (index != -1) {
                    openItemDetails(recommendedProductIds[index]);
                }
            }
        };

        productImage1.setOnClickListener(productClickListener);
        productImage2.setOnClickListener(productClickListener);
        productImage3.setOnClickListener(productClickListener);
        productImage4.setOnClickListener(productClickListener);
    }


    // Uppdatera openItemDetails-metoden
    private void openItemDetails(String productId) {
        Intent intent = new Intent(HemsidaActivity.this, item_detailsActivity.class);
        intent.putExtra("product_id", productId);
        startActivity(intent);
    }
}