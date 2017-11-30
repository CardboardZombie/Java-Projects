package com.cybertiger.workout;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity implements WorkoutListListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public void itemClicked(long id){
        View fragmentContainer = findViewById(R.id.stopwatch_container);
        if(fragmentContainer != null){
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            details.setWorkout(id);

            FragmentTransaction ft = getFragmentManager().beginTransaction();

            ft.replace(R.id.stopwatch_container, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int)id);
            startActivity(intent);
        }
        //the code to set the detail will go here

    }
}
