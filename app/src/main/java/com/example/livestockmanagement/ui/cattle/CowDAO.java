package com.example.livestockmanagement.ui.cattle;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.livestockmanagement.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class CowDAO {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public CowDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public void insertCow(Cow cow) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, cow.getName());
        values.put(DatabaseHelper.COLUMN_TAG, cow.getTagNumber());
        values.put(DatabaseHelper.COLUMN_HEALTH_STATUS, cow.getHealthStatus().toString());
        values.put(DatabaseHelper.COLUMN_BREED, cow.getBreed());
        values.put(DatabaseHelper.COLUMN_AGE, cow.getAge());
        values.put(DatabaseHelper.COLUMN_PURPOSE, cow.getPurpose());
        values.put(DatabaseHelper.COLUMN_WEIGHT, cow.getWeight());
        database.insert(DatabaseHelper.TABLE_COWS, null, values);
    }

    public List<Cow> getAllCows() {
        List<Cow> cows = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHelper.TABLE_COWS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_ID);
                int nameIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int tagIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_TAG);
                int healthStatusIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_HEALTH_STATUS);
                int breedIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_BREED);
                int ageIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_AGE);
                int purposeIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_PURPOSE);
                int weightIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_WEIGHT);

                if (idIndex >= 0 && nameIndex >= 0 && tagIndex >= 0 && healthStatusIndex >= 0 &&
                        breedIndex >= 0 && ageIndex >= 0 && purposeIndex >= 0 && weightIndex >= 0) {

                    Cow cow = new Cow();
                    //cow.setId(cursor.getInt(idIndex));
                    cow.setName(cursor.getString(nameIndex));
                    cow.setTagNumber(cursor.getString(tagIndex));
                    cow.setHealthStatus(Cow.HealthStatus.valueOf(cursor.getString(healthStatusIndex)));
                    cow.setBreed(cursor.getString(breedIndex));
                    cow.setAge(cursor.getInt(ageIndex));
                    cow.setPurpose(cursor.getString(purposeIndex));
                    cow.setWeight(cursor.getInt(weightIndex));
                    cows.add(cow);
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return cows;
    }
    public void close() {
        dbHelper.close();
    }

}
