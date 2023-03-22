package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HemsidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemsida);
    }

    public void goToFiltreringsSida(View view) {
        Intent intent = new Intent(this, FiltreringSidaActivity.class);
        startActivity(intent);
    }

    public void goToLoginSida(View view) {
        Intent intent = new Intent(this, InloggningssidaActivity.class);
        startActivity(intent);
    }
}