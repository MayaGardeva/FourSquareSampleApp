package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class VenuesResponse {

    @SerializedName("response")
    private Response response;

    public Response getResponse() {
        return response;
    }
}
