package com.example.bankaccounts.ui.login;

import android.app.Activity;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bankaccounts.R;
import com.example.bankaccounts.MyDatabase;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Accounts";

    // Table name: Accounts.
    private static final String TABLE_ACCOUNTS = "Accounts";

    private static final String COLUMN_ID ="Account_Id";
    private static final String COLUMN_AMOUNT = "Amount";
    private static final String COLUMN_IBAN = "Iban";
    private static final String COLUMN_CURRENCY = "Currency";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText accountIdEditText = findViewById(R.id.accountId);
        final Button loginButton = findViewById(R.id.login);
        final Button deleteButton = findViewById(R.id.delete);
        loginButton.setClickable(true);
        loginButton.setEnabled(true);
        deleteButton.setClickable(true);
        deleteButton.setEnabled(true);


        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                if (loginFormState.getAccountIdError() != null) {
                    accountIdEditText.setError(getString(loginFormState.getAccountIdError()));
                }
            }
        });

        Context context = this;
        loginButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                //SecureRandom random = new SecureRandom();
               // byte[] sel = new byte[16];
                //random.nextBytes(sel);
                String hashed_id = "";
                try {
                    MessageDigest m = MessageDigest.getInstance("sha-512");
                    //m.update(sel);
                    byte[] hashed = m.digest(accountIdEditText.getText().toString().getBytes());
                    hashed_id =  new String(hashed, StandardCharsets.UTF_8);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                //loginViewModel.login(accountIdEditText.getText().toString());
                MyDatabase db = new MyDatabase(context);

                if(!db.getAccount(hashed_id)){
                    db.syncAccount(accountIdEditText.getText().toString());
                }
                setContentView(R.layout.activity_add_edit_account);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabase db = new MyDatabase(context);

            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayAccountId();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}