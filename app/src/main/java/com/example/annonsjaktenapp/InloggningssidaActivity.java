package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InloggningssidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inloggningssida);
    }

    public void goToHemSida(View view) {
        Intent intent = new Intent(this, HemsidaActivity.class);
        startActivity(intent);
    }
}