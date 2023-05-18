package com.example.annonsjaktenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * En aktivitetsklass som visar detaljer för en produkt.
 */
public class item_detailsActivity extends BaseActivity {

    private TextView title; // Textvy för produkttitel
    private TextView description; // Textvy för produktbeskrivning
    private ImageView image; // Bildvy för produktbild

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Visa tillbaka-knappen i verktygsfältet

        title = findViewById(R.id.item_title);
        description = findViewById(R.id.item_description);
        image = findViewById(R.id.item_image);
        setUpBottomNavigation();

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");

        if (product != null) {
            title.setText(product.getTitle());
            description.setText(product.getDescription());
            image.setImageResource(product.getImageResId());
        }
    }

    /**
     * Hanterar klickhändelsen för menyalternativet.
     *
     * @param item Det valda menyalternativet.
     * @return true om händelsen hanterades, annars false.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // Hantera klick på tillbaka-knappen
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
