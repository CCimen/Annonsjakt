package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * En aktivitetsklass som visar filtreringsalternativ för annonser.
 */
public class FilterActivity extends AppCompatActivity {

    private CheckBox blocketCheckbox, traderaCheckbox, ebayCheckbox; // Checkboxar för filtreringsalternativ
    private Button applyFilterButton; // Knapp för att tillämpa filtrering

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        blocketCheckbox = findViewById(R.id.blocket_checkbox);
        traderaCheckbox = findViewById(R.id.tradera_checkbox);
        ebayCheckbox = findViewById(R.id.ebay_checkbox);
        applyFilterButton = findViewById(R.id.apply_filter_button);

        // Sätter initiala kryssruteinställningar
        blocketCheckbox.setChecked(getIntent().getBooleanExtra("blocket", false));
        traderaCheckbox.setChecked(getIntent().getBooleanExtra("tradera", false));
        ebayCheckbox.setChecked(getIntent().getBooleanExtra("ebay", false));

        applyFilterButton.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("blocket", blocketCheckbox.isChecked());
            resultIntent.putExtra("tradera", traderaCheckbox.isChecked());
            resultIntent.putExtra("ebay", ebayCheckbox.isChecked());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }

    /**
     * Hanterar menyobjektets klickhändelser.
     *
     * @param item Det klickade menyobjektet.
     * @return `true` om händelsen hanterades, annars `false`.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed(); // Går tillbaka till föregående aktivitet när hemknappen klickas
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
