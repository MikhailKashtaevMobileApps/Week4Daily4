
package com.example.mike.dicks.ui.model.venue_gson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venues {

    @SerializedName("venues")
    @Expose
    private List<Venue_> venues = null;

    public List<Venue_> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue_> venues) {
        this.venues = venues;
    }

}
