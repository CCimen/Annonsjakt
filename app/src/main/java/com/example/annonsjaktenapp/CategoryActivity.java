package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int selectedCategory = getIntent().getIntExtra("selected_category", 1);
        switch (selectedCategory) {
            case 2:
                setContentView(R.layout.skonhet_categoryvy);
                break;
            case 3:
                setContentView(R.layout.mobil_categoryvy);
                break;
            case 4:
                setContentView(R.layout.klader_categoryvy);
                break;
            case 1:
            default:
                setContentView(R.layout.dator_categoryvy);
                break;
        }
    }
}
