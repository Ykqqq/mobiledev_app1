package com.example.bankaccounts;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;

import com.example.bankaccounts.Accounts;
import com.example.bankaccounts.MyDatabase;

public class AddEditAccountActivity extends AppCompatActivity {
    private TextView textAmount;
    private TextView textIban;
    private TextView textCurrency;
    private Button buttonReturn;

    private Accounts account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_account);

        TextView textAmount = (TextView)this.findViewById(R.id.Text_amount);
        this.textIban = (TextView)this.findViewById(R.id.Text_iban);
        this.textCurrency = (TextView)this.findViewById(R.id.Text_currency);

        this.buttonReturn = (Button)findViewById(R.id.button_return);

        this.buttonReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                buttonCancelClicked();
            }
        });
    }

    // User Click on the Cancel button.
    public void buttonCancelClicked()  {
        // Do nothing, back MainActivity.
        this.onBackPressed();
        setContentView(R.layout.activity_login);
    }

    // When completed this Activity,
    // Send feedback to the Activity called it.
    @Override
    public void finish() {
        super.finish();
    }

}
