package com.cybertiger.cyberportfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.CheckBox;
import android.content.ContentValues;
import android.os.AsyncTask;

public class SketchActivity extends AppCompatActivity {

    public static final String EXTRA_SKETCH_NO = "sketchNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sketch);

        //Get the Sketch from the intent
        int sketchNo = (Integer) getIntent().getExtras().get(EXTRA_SKETCH_NO);

        //Create a Cursor
        try {
            SQLiteOpenHelper cyberPortfolioDatabaseHelper = new CyberPortfolioDatabaseHelper(this);
            SQLiteDatabase db = cyberPortfolioDatabaseHelper.getWritableDatabase();
            Cursor cursor = db.query("SKETCH",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVOURITE"},
                    "_id=?",
                    new String[]{Integer.toString(sketchNo)},
                    null, null, null);

            //Move to the first record in the Cursor
            if (cursor.moveToFirst()) {

                //Get the sketch details from the cursor
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                boolean isFavourite = (cursor.getInt(3) == 1);

                //Populate the Sketch Name
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);

                //Populate the Sketch Description
                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);

                //Populate the sketch image
                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                //Populate the favourite checkbox
                CheckBox favourite = (CheckBox) findViewById(R.id.favourite);
                favourite.setChecked(isFavourite);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    //Update the database when the checkbox is clicked
    public void onFavouriteClicked(View view) {
        int sketchNo = (Integer) getIntent().getExtras().get("sketchNo");
        new UpdateSketchTask().execute(sketchNo);
    }

    //Inner class to update the Sketch
    private class UpdateSketchTask extends AsyncTask<Integer, Void, Boolean>{
        ContentValues sketchValues;

        protected void onPreExecute(){
            CheckBox favourite = (CheckBox)findViewById(R.id.favourite);
            sketchValues = new ContentValues();
            sketchValues.put("FAVOURITE", favourite.isChecked());
        }

        protected Boolean doInBackground(Integer...sketches){
            int sketchNo = sketches[0];
            SQLiteOpenHelper cyberDatabaseHelper = new CyberPortfolioDatabaseHelper(SketchActivity.this);
            try{
                SQLiteDatabase db = cyberDatabaseHelper.getWritableDatabase();
                db.update("SKETCH", sketchValues, "_id=?", new String[] {Integer.toString(sketchNo)});
                db.close();
                return true;
            } catch(SQLiteException e){
                return false;
            }
        }

        protected void onPostExecute(Boolean success){
            if(!success){
                Toast toast = Toast.makeText(SketchActivity.this, "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
