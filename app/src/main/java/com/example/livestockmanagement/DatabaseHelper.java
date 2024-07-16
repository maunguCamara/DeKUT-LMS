package com.example.livestockmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "livestock.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "cows";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TAG = "tag";
    public static final String COLUMN_HEALTH_STATUS = "health_status";
    public static final String COLUMN_BREED = "breed";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_PURPOSE = "purpose";
    public static final String COLUMN_WEIGHT = "weight";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
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
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addCow(String name, String tagNumber, String breed, String gender, String purpose, int age, int weight){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_AGE, age);
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_BREED, breed);
        cv.put(COLUMN_TAG, tagNumber);
        cv.put(COLUMN_PURPOSE, purpose);
        cv.put(COLUMN_WEIGHT, weight);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1) {
            Toast.makeText(context , "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    // New function to delete a cow
    void deleteCow(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{id});
        if(result == -1) {
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully deleted", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}