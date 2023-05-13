package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InloggningssidaActivity extends AppCompatActivity {

    private EditText anvandarnamn;
    private EditText losenord;
    private TextView loginStatus;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inloggningssida);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // enable the back button

        anvandarnamn = (EditText) findViewById(R.id.anvandarnamn);
        losenord = (EditText) findViewById(R.id.losenord);
        loginStatus = (TextView) findViewById(R.id.login_status);
        loginButton = (Button) findViewById(R.id.btn_login);

        Button btnGoToHemSida = (Button) findViewById(R.id.btn_go_to_hemsida);
        btnGoToHemSida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHemSida();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String username = anvandarnamn.getText().toString();
        String password = losenord.getText().toString();

        // Here you should handle your login logic. For example, check the username and password.
        // If the login is successful:

        loginStatus.setText("Du har loggats in! Välkommen " + username);
    }

    public void goToHemSida() {
        Intent intent = new Intent(this, HemsidaActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
