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
        put("1_0", new ProductInfo("Dator 1 Titel", "Dator 1 Beskrivning", R.drawable.datorproduct1));
        put("1_1", new ProductInfo("Dator 2 Titel", "Dator 2 Beskrivning", R.drawable.datorproduct2));
        put("1_2", new ProductInfo("Dator 3 Titel", "Dator 3 Beskrivning", R.drawable.datorproduct3));
        put("1_3", new ProductInfo("Dator 4 Titel", "Dator 4 Beskrivning", R.drawable.datorproduct4));
        put("1_4", new ProductInfo("Dator 5 Titel", "Dator 5 Beskrivning", R.drawable.datorproduct5));


        // Lägg till ytterligare datorprodukter här
        put("2_0", new ProductInfo("Skönhet 1 Titel", "Skönhet 1 Beskrivning", R.drawable.skonhetproduct1));
        put("2_1", new ProductInfo("Skönhet 2 Titel", "Skönhet 2 Beskrivning", R.drawable.skonhetproduct2));
        put("2_2", new ProductInfo("Skönhet 3 Titel", "Skönhet 3 Beskrivning", R.drawable.skonhetproduct3));
        put("2_3", new ProductInfo("Skönhet 4 Titel", "Skönhet 4 Beskrivning", R.drawable.skonhetproduct4));
        put("2_4", new ProductInfo("Skönhet 5 Titel", "Skönhet 5 Beskrivning", R.drawable.skonhetproduct5));

        put("3_0", new ProductInfo("Mobil 1 Titel", "Mobil 1 Beskrivning", R.drawable.mobilproduct1));
        put("3_1", new ProductInfo("Mobil 2 Titel", "Mobil 2 Beskrivning", R.drawable.mobilproduct2));
        put("3_2", new ProductInfo("Mobil 3 Titel", "Mobil 3 Beskrivning", R.drawable.mobilproduct3));
        put("3_3", new ProductInfo("Mobil 4 Titel", "Mobil 4 Beskrivning", R.drawable.mobilproduct4));
        put("3_4", new ProductInfo("Mobil 5 Titel", "Mobil 5 Beskrivning", R.drawable.mobilproduct5));

        put("4_0", new ProductInfo("Kläder 1 Titel", "Mobil 1 Beskrivning", R.drawable.kladerproduct1));
        put("4_1", new ProductInfo("Kläder 2 Titel", "Mobil 2 Beskrivning", R.drawable.kladerproduct2));
        put("4_2", new ProductInfo("Kläder 3 Titel", "Mobil 3 Beskrivning", R.drawable.kladerproduct3));
        put("4_3", new ProductInfo("Kläder 4 Titel", "Mobil 4 Beskrivning", R.drawable.kladerproduct4));
        put("4_4", new ProductInfo("Kläder 5 Titel", "Mobil 5 Beskrivning", R.drawable.kladerproduct5));
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
