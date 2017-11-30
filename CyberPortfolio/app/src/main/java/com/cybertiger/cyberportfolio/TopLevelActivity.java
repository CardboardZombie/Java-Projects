package com.cybertiger.cyberportfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;
import android.widget.CursorAdapter;
import android.widget.Toast;

public class TopLevelActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor favouritesCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        //Create an OnItemClickListener for the Options ListView
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick (AdapterView<?> parent, View v, int position, long id){
              if(position == 0){
                  Intent intent = new Intent(TopLevelActivity.this, SketchCategoryActivity.class);
                  startActivity(intent);
              }
          }
        };
        //Add the listener to the list view
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);

        //Populate the list_favourites ListView from a cursor
        ListView listFavourites = (ListView)findViewById(R.id.list_favourites);
        try{
            SQLiteOpenHelper cyberPortfolioDatabaseHelper = new CyberPortfolioDatabaseHelper(this);
            db = cyberPortfolioDatabaseHelper.getReadableDatabase();
            favouritesCursor = db.query("SKETCH", new String[]{"_id", "NAME"}, "FAVOURITE = 1", null, null, null, null);

            CursorAdapter favouritesAdapter = new SimpleCursorAdapter(TopLevelActivity.this, android.R.layout.simple_list_item_1, favouritesCursor, new String[]{"NAME"}, new int[]{android.R.id.text1}, 0);

            listFavourites.setAdapter(favouritesAdapter);


        //Navigate to SketchActivity if a Sketch is Clicked
        listFavourites.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                Intent intent = new Intent(TopLevelActivity.this, SketchActivity.class);
                intent.putExtra(SketchActivity.EXTRA_SKETCH_NO, (int)id);
                startActivity(intent);
            }
        });
        } catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    //Close the cursor and database in the onDestroy() method
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(favouritesCursor != null) {
            favouritesCursor.close();
        }
        if(db != null) {
            db.close();
        }
    }
    @Override
    public void onRestart(){
        super.onRestart();
        try{
            CyberPortfolioDatabaseHelper cPortfolioDBHelper = new CyberPortfolioDatabaseHelper(this);
            db = cPortfolioDBHelper.getReadableDatabase();
            Cursor newCursor = db.query("SKETCH", new String[] {"_id", "NAME"}, "FAVOURITE = 1", null, null, null, null);
            ListView listFavourites = (ListView)findViewById(R.id.list_favourites);
            CursorAdapter adapter = (CursorAdapter) listFavourites.getAdapter();
            adapter.changeCursor(newCursor);
            favouritesCursor = newCursor;
        } catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
