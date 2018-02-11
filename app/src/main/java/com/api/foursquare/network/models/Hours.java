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
    private String isOpen;

    public String getIsLocalHoliday() {
        return isLocalHoliday;
    }

    public String getStatus() {
        return status;
    }

    public String getIsOpen() {
        return isOpen;
    }
}
