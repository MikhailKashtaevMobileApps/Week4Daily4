package com.example.mike.dicks.ui.main;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mike.dicks.R;
import com.example.mike.dicks.ui.model.venue_gson.Venue;
import com.example.mike.dicks.ui.utils.ImageEditor;

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
        Venue v = items.get(i);
        // Setting photo
        if ( v.getPhotos().size() > 0){
            ImageEditor ie = new ImageEditor(viewHolder.venueImage);
            ie.setImage( v.getPhotos().get(0).getUrl() );
        }
        // Setting address
        if ( v.getLocation() != null ){
            viewHolder.venueAddress.setText( v.getLocation().getAddress() );
        }

        // Setting score
        viewHolder.venueScore.setText( String.valueOf(v.getRating()) );
        if ( v.getRatingColor() != null ){
            viewHolder.venueScore.setTextColor(Color.parseColor( "#"+v.getRatingColor() ) );
        }

        // Setting website link
        if ( v.getUrl() != null ) {
            final String link = v.getUrl();
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            venueImage = itemView.findViewById( R.id.ivVenueImage );
            venueAddress = itemView.findViewById( R.id.tvVenueAddress );
            venueScore = itemView.findViewById( R.id.tvVenueScore );
            venueWebsite = itemView.findViewById( R.id.tvVenueWebsite );
        }
    }
}
