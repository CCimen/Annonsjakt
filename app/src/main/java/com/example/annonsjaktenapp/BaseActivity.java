package com.example.annonsjaktenapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.Intent;
import android.view.MenuItem;

/**
 * En abstrakt basaktivitetsklass som innehåller gemensam funktionalitet för aktiviteter.
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Ställer in navigeringsmenyn i botten av skärmen.
     */
    protected void setUpBottomNavigation() {
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_button:
                        Intent homeIntent = new Intent(BaseActivity.this, HemsidaActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.favorite_button:
                        Intent favoriteIntent = new Intent(BaseActivity.this, activity_favorite.class);
                        startActivity(favoriteIntent);
                        break;
                    case R.id.profile_button:
                        Intent profileIntent = new Intent(BaseActivity.this, InloggningssidaActivity.class);
                        startActivity(profileIntent);
                        break;
                    // Hantera andra navigeringsobjekt här
                }
                return true;
            }
        });
    }
}
