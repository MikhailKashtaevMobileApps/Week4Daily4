package com.example.mike.dicks.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mike.dicks.R;
import com.example.mike.dicks.ui.model.Repository;
import com.example.mike.dicks.ui.model.venue_gson.Venues;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository.getVenues(new Repository.Callback() {
            @Override
            public void onSuccess(Venues venues) {
                Toast.makeText( getApplicationContext(), "Total venues="+venues.getVenues().size(), Toast.LENGTH_LONG ).show();
            }

            @Override
            public void onFailure(Throwable e) {
                Toast.makeText( getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG ).show();
            }
        });

    }





}
