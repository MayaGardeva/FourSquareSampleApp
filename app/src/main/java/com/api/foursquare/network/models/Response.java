package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class Response {

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("query")
    private String query;

    @SerializedName("headerLocation")
    private String headerLocation;

    @SerializedName("headerFullLocation")
    private String headerFullLocation;

    @SerializedName("groups")
    private Groups[] groups;

    public String getTotalResults() {
        return totalResults;
    }

    public String getQuery() {
        return query;
    }

    public String getHeaderLocation() {
        return headerLocation;
    }

    public String getHeaderFullLocation() {
        return headerFullLocation;
    }

    public Groups[] getGroups() {
        return groups;
    }

    public boolean isValidResponse() {
        return  (groups != null && groups.length > 0 && groups[0].isValidResponse());
    }
}
