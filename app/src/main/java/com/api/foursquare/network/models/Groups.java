package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class Groups {

    @SerializedName("items")
    private Items[] items;

    public Items[] getItems() {
        return items;
    }

    public boolean isValidResponse() {
        return items != null && items.length > 0 && items[0].isValidResponse();
    }
}
