package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class StartsidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startsida);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(StartsidaActivity.this, HemsidaActivity.class);
                startActivity(i);
                finish();
            }
        }, 1000); // delay of 1 second (1000 milliseconds)
    }
}
