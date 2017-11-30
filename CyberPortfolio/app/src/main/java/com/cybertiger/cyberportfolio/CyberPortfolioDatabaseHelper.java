package com.cybertiger.cyberportfolio;

/**
 * Created by Tadhg Deeney on 29/05/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


class CyberPortfolioDatabaseHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "CyberPortfolio"; //The Name of our Database
    private static final int DB_VERSION = 2;                //The Version of our Database

    CyberPortfolioDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        updateMyDatabase(db, 0, DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        updateMyDatabase(db, oldVersion, newVersion);
    }
    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion < 1) {
            db.execSQL("CREATE TABLE SKETCH (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, IMAGE_RESOURCE_ID INTEGER);");
            insertSketch(db, "Chameleon", "A Sketch used to develop interest in the prototype for Zoo Buddy Icon", R.drawable.chameleon);
            insertSketch(db, "Owls", "Playing around with color in PhotoShop", R.drawable.owls);
            insertSketch(db, "Big Friendly Elephants", "Flat Elephant Design", R.drawable.elephants);
        }
        if(oldVersion < 2){
            //Code to add the extra column
            db.execSQL("ALTER TABLE SKETCH ADD COLUMN FAVOURITE NUMERIC;");
        }
    }
    private static void insertSketch(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues sketchValues = new ContentValues();
        sketchValues.put("NAME", name);
        sketchValues.put("DESCRIPTION", description);
        sketchValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("SKETCH", null, sketchValues);
    }
}
