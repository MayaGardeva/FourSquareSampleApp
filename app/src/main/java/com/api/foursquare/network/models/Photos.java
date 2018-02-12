package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 12/02/2018.
 */

public class Photos {

    @SerializedName("groups")
    private PhotoGroups[] groups;

    public PhotoGroups[] getGroups() {
        return groups;
    }
}
