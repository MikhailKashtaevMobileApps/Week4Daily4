package com.example.mike.dicks.ui.main;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mike.dicks.R;
import com.example.mike.dicks.ui.model.Repository;
import com.example.mike.dicks.ui.model.venue_gson.Venue;
import com.example.mike.dicks.ui.model.venue_gson.Venues;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewAdapter adapter;
    private RecyclerView venuesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        venuesList = findViewById( R.id.rvVenuesList );
        adapter = new RecyclerViewAdapter( new ArrayList<Venue>());
        venuesList.setLayoutManager( new LinearLayoutManager(this));
        venuesList.setAdapter(adapter);

        // Retrieving venues
        Repository.getVenues(new Repository.Callback() {
            @Override
            public void onSuccess(Venues venues) {
                adapter.items = (ArrayList<Venue>) venues.getVenues();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable e) {
                Toast.makeText( getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG ).show();
            }
        });


        //Setting logo
        ImageView DSGLogo = findViewById( R.id.DSGLogo );
        try {
            DSGLogo.setImageBitmap(BitmapFactory.decodeStream( getAssets().open("DSGLogo-FlatGreen.png")) );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
