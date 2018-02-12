package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class Items {

    @SerializedName("venue")
    private Venue venue;

    @SerializedName("tips")
    private Tip[] tips;

    public Venue getVenue() {
        return venue;
    }

    public boolean isValidResponse() {
        return venue != null;
    }

    public Tip[] getTips() {
        return tips;
    }
}
