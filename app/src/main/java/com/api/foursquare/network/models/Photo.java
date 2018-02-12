package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 12/02/2018.
 */

public class Photo {

    @SerializedName("prefix")
    private String prefix;

    @SerializedName("suffix")
    private String suffix;

    public String getSuffix() {
        return suffix;
    }

    public String getPrefix() {
        return prefix;
    }
}
