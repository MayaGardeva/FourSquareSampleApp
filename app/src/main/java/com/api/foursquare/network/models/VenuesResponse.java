package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class VenuesResponse {

    @SerializedName("response")
    private Response response;

    public Response getResponse() {
        return response;
    }

    public boolean isValidResponse() {
        return (response != null && response.isValidResponse());
    }

    public List<Venue> getVenues() {
        List<Venue> venues = new ArrayList<>();
        if (isValidResponse()) {
            Items[] items = response.getGroups()[0].getItems();
            for (Items item : items) {
                venues.add(item.getVenue());
            }
        }

        return venues;
    }
}
