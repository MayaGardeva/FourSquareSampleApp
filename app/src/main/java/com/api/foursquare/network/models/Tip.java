package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 12/02/2018.
 */

public class Tip {

    @SerializedName("photo")
    private Photo photo;

    public Photo getPhoto() {
        return photo;
    }
}
