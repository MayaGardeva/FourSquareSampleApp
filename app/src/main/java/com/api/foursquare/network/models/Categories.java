package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class Categories {

    @SerializedName("id")
    private String id;

    @SerializedName("primary")
    private String primary;

    @SerializedName("name")
    private String name;

    @SerializedName("shortName")
    private String shortName;

    @SerializedName("pluralName")
    private String pluralName;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
