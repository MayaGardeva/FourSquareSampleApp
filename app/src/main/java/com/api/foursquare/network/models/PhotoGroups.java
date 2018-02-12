package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 12/02/2018.
 */

public class PhotoGroups {

    @SerializedName("count")
    private String count;

    @SerializedName("items")
    private PhotoItems[] items;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    public String getName() {
        return name;
    }

    public PhotoItems[] getItems() {
        return items;
    }
}
