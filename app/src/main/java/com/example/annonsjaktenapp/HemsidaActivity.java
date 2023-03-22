package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;



public class HemsidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemsida);

        // Variabler för att länka bilderna till kategorivyn
        ImageView categoryImage1 = findViewById(R.id.category_image1);
        ImageView categoryImage2 = findViewById(R.id.category_image2);
        ImageView categoryImage3 = findViewById(R.id.category_image3);
        ImageView categoryImage4 = findViewById(R.id.category_image4);


        categoryImage1.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("category_id", 1);
            startActivity(intent);
        });

        categoryImage2.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("category_id", 2);
            startActivity(intent);
        });

        categoryImage3.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("category_id", 3);
            startActivity(intent);
        });

        categoryImage4.setOnClickListener(v -> {
            Intent intent = new Intent(HemsidaActivity.this, CategoryActivity.class);
            intent.putExtra("category_id", 4);
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
    }
}
