package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class item_detailsActivity extends AppCompatActivity {

    private class ProductInfo {
        String title;
        String description;
        int imageResourceId;

        ProductInfo(String title, String description, int imageResourceId) {
            this.title = title;
            this.description = description;
            this.imageResourceId = imageResourceId;
        }
    }

    private HashMap<String, ProductInfo> productInfoMap = new HashMap<String, ProductInfo>() {{
        put("1_0", new ProductInfo("Dator 1 Titel", "Dator 1 Beskrivning", R.drawable.product_image1));
        put("1_1", new ProductInfo("Dator 2 Titel", "Dator 2 Beskrivning", R.drawable.product_image2));
        put("1_2", new ProductInfo("Dator 3 Titel", "Dator 3 Beskrivning", R.drawable.product_image3));
        put("1_3", new ProductInfo("Dator 4 Titel", "Dator 4 Beskrivning", R.drawable.product_image4));

        // Lägg till ytterligare datorprodukter här
        put("2_0", new ProductInfo("Skönhet 1 Titel", "Skönhet 1 Beskrivning", R.drawable.product_image3));
        put("2_1", new ProductInfo("Skönhet 2 Titel", "Skönhet 2 Beskrivning", R.drawable.product_image4));
        // Lägg till ytterligare skönhetprodukter här
        // Lägg till ytterligare kategorier och produkter här
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        int categoryId = getIntent().getIntExtra("category_id", 1);
        int itemIndex = getIntent().getIntExtra("item_index", 0);

        String productId = categoryId + "_" + itemIndex;
        ProductInfo productInfo = productInfoMap.get(productId);

        TextView titleTextView = findViewById(R.id.item_title);
        TextView descriptionTextView = findViewById(R.id.item_description);
        ImageView imageView = findViewById(R.id.item_image);

        titleTextView.setText(productInfo.title);
        descriptionTextView.setText(productInfo.description);
        imageView.setImageResource(productInfo.imageResourceId);
    }
}
