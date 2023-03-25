package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ListVyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vy);
        setUpBottomNavigation();
    }
}