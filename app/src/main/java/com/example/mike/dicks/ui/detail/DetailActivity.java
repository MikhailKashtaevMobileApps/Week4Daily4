package com.example.mike.dicks.ui.detail;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mike.dicks.R;
import com.example.mike.dicks.model.venue_gson.Photo;
import com.example.mike.dicks.model.venue_gson.Venue;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Venue venue = (Venue) getIntent().getExtras().get("data");

        Toast.makeText( this, venue.toString(), Toast.LENGTH_LONG ).show();

        if ( venue.getPhotos() != null ) {
            ArrayList<String> urls = new ArrayList<>();

            for (Photo photo : venue.getPhotos()) {
                urls.add(photo.getUrl());
            }

            ViewPager viewPager = findViewById( R.id.vpImageCarousel );
            viewPager.setAdapter( new PagerViewAdapter( urls ) );
        }

    }
}
