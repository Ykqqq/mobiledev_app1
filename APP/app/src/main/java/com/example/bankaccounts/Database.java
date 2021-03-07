package com.example.bankaccounts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/*
public class Database {

    ///////////////////////// CREATE DATABASE ///////////////////////////////////

    private Database() {}

    // Inner class that defines the table contents
    public class Accounts implements BaseColumns {
        public static final String TABLE_NAME = "account";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Accounts.TABLE_NAME + " (" +
                    Accounts._ID + " INTEGER PRIMARY KEY," +
                    Accounts.COLUMN_NAME_TITLE + " TEXT," +
                    Accounts.COLUMN_NAME_SUBTITLE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Accounts.TABLE_NAME;



    public class FeedReaderDbHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "FeedReader.db";

        public FeedReaderDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }


    /////////////////////////// PUT INFORMATION IN DATABASE //////////////////////////
    FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(getContext());

    // Gets the data repository in write mode
    SQLiteDatabase db = dbHelper.getWritableDatabase();

    public void addAccount(String title, String subtitle){
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Accounts.COLUMN_NAME_TITLE, title);
        values.put(Accounts.COLUMN_NAME_SUBTITLE, subtitle);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Accounts.TABLE_NAME, null, values);
    }

    /////////////////////////// READ FROM DATABASE ///////////////////////////////////

    public void readAccount(){
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                Accounts.COLUMN_NAME_TITLE,
                Accounts.COLUMN_NAME_SUBTITLE
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = Accounts.COLUMN_NAME_TITLE + " = ?";
        String[] selectionArgs = { "My Title" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                Accounts.COLUMN_NAME_SUBTITLE + " DESC";

        Cursor cursor = db.query(
                Accounts.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
    }

    /////////////////////////// UPDATE DATABASE /////////////////////////////////////

    public void updateAccount(String title){
        ContentValues values = new ContentValues();
        values.put(Accounts.COLUMN_NAME_TITLE, title);

        // Which row to update, based on the title
        String selection = Accounts.COLUMN_NAME_TITLE + " LIKE ?";
        String[] selectionArgs = { "MyOldTitle" };

        int count = db.update(
                FeedReaderDbHelper.Accounts.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    /////////////////////////// DELETE FROM DATABASE ////////////////////////////////

    public void deleteAccount(){
        // Define 'where' part of query.
        String selection = Accounts.COLUMN_NAME_TITLE + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { "MyTitle" };
        // Issue SQL statement.
        int deletedRows = db.delete(Accounts.TABLE_NAME, selection, selectionArgs);
    }


}

*/