package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class Items {

    @SerializedName("venue")
    private Venue venue;

    public Venue getVenue() {
        return venue;
    }
}
