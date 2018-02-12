package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class Location {

    @SerializedName("distance")
    private String distance;

    @SerializedName("postalCode")
    private String postalCode;

    @SerializedName("address")
    private String address;

    @SerializedName("state")
    private String state;

    @SerializedName("formattedAddress")
    private String[] formattedAddress;

    @SerializedName("lng")
    private String lng;

    @SerializedName("cc")
    private String cc;

    @SerializedName("lat")
    private String lat;

    @SerializedName("country")
    private String country;

    @SerializedName("city")
    private String city;

    @SerializedName("crossStreet")
    private String crossStreet;

    public String[] getFormattedAddress() {
        return formattedAddress;
    }

}
