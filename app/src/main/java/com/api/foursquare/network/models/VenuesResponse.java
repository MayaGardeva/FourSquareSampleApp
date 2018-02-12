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
        return  (response != null && response.isValidResponse());
    }

    public List<Venue> getVenues() {
        List<Venue> venues = new ArrayList<>();
        if (isValidResponse()) {
            Items[] items = response.getGroups()[0].getItems();
            for (Items item : items) {
                Venue venue = item.getVenue();
                venue.setImageUrl(getImageUrl(item.getTips()));
                venues.add(venue);
            }
        }

        return venues;
    }

    private String getImageUrl(Tip[] tips) {
        if (tips != null && tips.length > 0) {
            Photo photo = tips[0].getPhoto();
            if (photo != null) {
                return photo.getPrefix() + "100x100" + photo.getSuffix();
            }
        }
        return "";
    }
}
