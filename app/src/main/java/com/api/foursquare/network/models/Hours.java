package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class Hours {

    @SerializedName("isLocalHoliday")
    private String isLocalHoliday;

    @SerializedName("status")
    private String status;

    @SerializedName("isOpen")
    private boolean isOpen;

    public String getStatus() {
        return status;
    }
}
