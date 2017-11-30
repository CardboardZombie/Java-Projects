package com.cybertiger.cyberportfolio;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.SimpleCursorAdapter;


public class SketchCategoryActivity extends ListActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listSketches = getListView();

        try{
            SQLiteOpenHelper cyberPortfolioDatabaseHelper = new CyberPortfolioDatabaseHelper(this);
            db = cyberPortfolioDatabaseHelper.getReadableDatabase();

            cursor = db.query("SKETCH", new String[]{"_id", "NAME"}, null, null, null, null, null);
            CursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"NAME"}, new int[]{android.R.id.text1}, 0);
            listSketches.setAdapter(listAdapter);
        } catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavilable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id){
        Intent intent = new Intent(SketchCategoryActivity.this, SketchActivity.class);
        intent.putExtra(SketchActivity.EXTRA_SKETCH_NO, (int) id);
        startActivity(intent);
    }
}
