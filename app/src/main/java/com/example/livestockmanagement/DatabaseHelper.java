package com.example.livestockmanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "livestock.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_COWS = "cows";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TAG = "tag";
    public static final String COLUMN_HEALTH_STATUS = "health_status";
    public static final String COLUMN_BREED = "breed";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_PURPOSE = "purpose";
    public static final String COLUMN_WEIGHT = "weight";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_COWS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_TAG + " TEXT, " +
                    COLUMN_HEALTH_STATUS + " TEXT, " +
                    COLUMN_BREED + " TEXT, " +
                    COLUMN_AGE + " INTEGER, " +
                    COLUMN_PURPOSE + " TEXT, " +
                    COLUMN_WEIGHT + " INTEGER" + ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COWS);
        onCreate(db);
    }
}