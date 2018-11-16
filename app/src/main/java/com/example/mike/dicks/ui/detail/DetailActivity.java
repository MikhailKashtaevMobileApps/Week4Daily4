package com.example.mike.dicks.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mike.dicks.R;
import com.example.mike.dicks.model.venue_gson.Venue;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Venue venue = (Venue) getIntent().getExtras().get("data");

        Toast.makeText( this, venue.toString(), Toast.LENGTH_LONG ).show();

    }
}
