package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 12/02/2018.
 */

public class PhotoItems {

    @SerializedName("suffix")
    private String suffix;

    @SerializedName("height")
    private String height;

    @SerializedName("prefix")
    private String prefix;

    @SerializedName("width")
    private String width;

    public String getUrl() {
        return prefix + width + "x" + height + suffix;
    }
}
