package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * En aktivitetsklass som hanterar inloggningssidan.
 */
public class InloggningssidaActivity extends AppCompatActivity {

    private EditText anvandarnamn; // Textfält för användarnamn
    private EditText losenord; // Textfält för lösenord
    private TextView loginStatus; // Textvy för inloggningsstatus
    private Button loginButton; // Knapp för att logga in

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inloggningssida);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Aktivera tillbaka-knappen

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

    /**
     * Hanterar inloggningsfunktionen när login-knappen klickas.
     */
    private void handleLogin() {
        String username = anvandarnamn.getText().toString();
        String password = losenord.getText().toString();

        loginStatus.setText("Du har loggats in! Välkommen " + username);
    }

    /**
     * Öppnar startsidan (HemsidaActivity).
     */
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
