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

    public String getCrossStreet() {
        return crossStreet;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getLat() {
        return lat;
    }

    public String getCc() {
        return cc;
    }

    public String getLng() {
        return lng;
    }

    public String[] getFormattedAddress() {
        return formattedAddress;
    }

    public String getState() {
        return state;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getDistance() {
        return distance;
    }
}
