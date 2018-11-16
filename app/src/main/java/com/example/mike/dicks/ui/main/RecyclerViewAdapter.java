package com.example.mike.dicks.ui.main;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mike.dicks.R;
import com.example.mike.dicks.ui.detail.DetailActivity;
import com.example.mike.dicks.model.venue_gson.Venue;
import com.example.mike.dicks.utils.ImageEditor;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<Venue> items;

    public RecyclerViewAdapter(List<Venue> items) {
        this.items = (ArrayList<Venue>) items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.venues_list_item, viewGroup, false );
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Venue venue = items.get(i);
        // Setting photo
        if ( venue.getPhotos().size() > 0){
            ImageEditor ie = new ImageEditor(viewHolder.venueImage);
            ie.setImage( venue.getPhotos().get(0).getUrl() );
        }
        // Setting address
        if ( venue.getLocation() != null ){
            viewHolder.venueAddress.setText( venue.getLocation().getAddress() );
        }

        // Setting score
        viewHolder.venueScore.setText( String.valueOf(venue.getRating()) );
        if ( venue.getRatingColor() != null ){
            viewHolder.venueScore.setTextColor(Color.parseColor( "#"+venue.getRatingColor() ) );
        }

        // Setting website link
        if ( venue.getUrl() != null ) {
            final String link = venue.getUrl();
            viewHolder.venueWebsite.setText(link);
            viewHolder.venueWebsite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(link));
                    v.getContext().startActivity(intent);
                }
            });
        }

        // Setting link to detail page
        viewHolder.daddyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra( "data", venue );
                v.getContext().startActivity( intent );
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView venueImage;
        TextView venueAddress;
        TextView venueScore;
        TextView venueWebsite;
        View daddyView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            daddyView = itemView;
            venueImage = itemView.findViewById( R.id.ivVenueImage );
            venueAddress = itemView.findViewById( R.id.tvVenueAddress );
            venueScore = itemView.findViewById( R.id.tvVenueScore );
            venueWebsite = itemView.findViewById( R.id.tvVenueWebsite );
        }
    }
}
