package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * En aktivitetsklass som visar filtreringsalternativ för annonser.
 */
public class FilterActivity extends AppCompatActivity {

    private CheckBox blocketCheckbox, traderaCheckbox, sellpyCheckbox; // Checkboxar för filtreringsalternativ
    private Button applyFilterButton; // Knapp för att tillämpa filtrering

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        blocketCheckbox = findViewById(R.id.blocket_checkbox);
        traderaCheckbox = findViewById(R.id.tradera_checkbox);
        sellpyCheckbox = findViewById(R.id.sellpy_checkbox);
        applyFilterButton = findViewById(R.id.apply_filter_button);

        // Load saved filter settings
        SharedPreferences sharedPref = getSharedPreferences("filter_preferences", Context.MODE_PRIVATE);
        blocketCheckbox.setChecked(sharedPref.getBoolean("Blocket", false));
        traderaCheckbox.setChecked(sharedPref.getBoolean("Tradera", false));
        sellpyCheckbox.setChecked(sharedPref.getBoolean("Sellpy", false));

        // Sätter initiala kryssruteinställningar
        applyFilterButton.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("Blocket", blocketCheckbox.isChecked());
            resultIntent.putExtra("Tradera", traderaCheckbox.isChecked());
            resultIntent.putExtra("Sellpy", sellpyCheckbox.isChecked());
            setResult(RESULT_OK, resultIntent);

            // Save the filter settings
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("Blocket", blocketCheckbox.isChecked());
            editor.putBoolean("Tradera", traderaCheckbox.isChecked());
            editor.putBoolean("Sellpy", sellpyCheckbox.isChecked());
            editor.apply();

            finish();
        });

    }

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
