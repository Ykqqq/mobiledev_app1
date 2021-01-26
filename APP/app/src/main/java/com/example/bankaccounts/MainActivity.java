package com.example.bankaccounts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    final Button button_login = findViewById(R.id.button_login);
    final EditText edit_id = findViewById(R.id.edit_id);
    final String id_hashed = getString(R.string.id_hashed);
    final String id = getString(R.string.id);
    final String accountName = getString(R.string.accountName);
    final String amount = getString(R.string.amount);
    final String iban = getString(R.string.iban);
    final String currency = getString(R.string.currency);
    final String name = getString(R.string.name);
    final String lastname = getString(R.string.lastName);
    // BASE SQLITE PLUTOT

    protected void onClick()
    {

    }
}