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
    private Button buttonUpdate;

    private Accounts account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_account);

        TextView textAmount = (TextView)this.findViewById(R.id.Text_amount);
        this.textIban = (TextView)this.findViewById(R.id.Text_iban);
        this.textCurrency = (TextView)this.findViewById(R.id.Text_currency);

        this.buttonReturn = (Button)findViewById(R.id.button_return);
        this.buttonUpdate = (Button)findViewById(R.id.button_update);

        this.buttonReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                buttonDeleteClicked();
            }
        });
        this.buttonUpdate.setOnClickListener(new View.OnClickListener(){
                public void onClick (View v){
                buttonUpdateClicked();
            }
        });
    }

    // User Click on the Cancel button.
    public void buttonDeleteClicked()  {
        // Do nothing, back MainActivity.
        this.onBackPressed();
        setContentView(R.layout.activity_login);
    }

    // User Click on the Cancel button.
    public void buttonUpdateClicked()  {
        // Do nothing, back MainActivity.
        this.onBackPressed();
        //call the syncAccount function
        setContentView(R.layout.activity_add_edit_account);
    }

    // When completed this Activity,
    // Send feedback to the Activity called it.
    @Override
    public void finish() {
        super.finish();
    }

}
