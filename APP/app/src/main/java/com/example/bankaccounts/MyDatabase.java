package com.example.bankaccounts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.bankaccounts.Accounts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyDatabase extends SQLiteOpenHelper{

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

    public MyDatabase(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {

        String script = "CREATE TABLE " + TABLE_ACCOUNTS + "("
                + COLUMN_ID + " TEXT PRIMARY KEY," + COLUMN_AMOUNT + " TEXT,"
                + COLUMN_IBAN + " TEXT," + COLUMN_CURRENCY + " TEXT" + ")";
        // Execute Script.
        db.execSQL(script);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);

        // Create tables again
        onCreate(db);
    }


    public int addAccount(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);

        // Create tables again
        onCreate(db);

        try {
            // Inserting Row
            db.insert(TABLE_ACCOUNTS, null, values);
            // Closing database connection
            db.close();
            return 1;
        }
        catch (Exception e){
            return -1;
        }
    }

    public boolean getAccount(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ACCOUNTS, new String[] {COLUMN_ID, COLUMN_AMOUNT, COLUMN_IBAN, COLUMN_CURRENCY }, COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            return true;
        else{
            return false;
        }

    }

    public void syncAccount(String id){
        AndroidNetworking.get("http://60102f166c21e10017050128.mockapi.io/labbbank/accounts/")
                .build()
                .getAsObject(Accounts.class, new ParsedRequestListener<JSONArray>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                if (obj.getString("id").equals(id)) {
                                    ContentValues values = new ContentValues();
                                    String hashed_id = "";
                                    try {
                                        MessageDigest m = MessageDigest.getInstance("sha-512");
                                        //m.update(sel);
                                        byte[] hashed = m.digest(id.toString().getBytes());
                                        hashed_id =  new String(hashed, StandardCharsets.UTF_8);
                                    } catch (NoSuchAlgorithmException e) {
                                        e.printStackTrace();
                                    }
                                    values.put(COLUMN_ID, hashed_id);
                                    values.put(COLUMN_AMOUNT, obj.getString("amount"));
                                    values.put(COLUMN_IBAN, obj.getString("iban"));
                                    values.put(COLUMN_CURRENCY, obj.getString("currency"));
                                    if (addAccount(values) == -1) {
                                        return;
                                    }
                                }
                            }
                            catch (JSONException e){
                                return;
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }


    public void delete() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);

        // Create tables again
        onCreate(db);
    }

}
