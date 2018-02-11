package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class Venue {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("location")
    private Location location;

    @SerializedName("hours")
    private Hours hours;

    @SerializedName("categories")
    private Categories[] categories;

    @SerializedName("rating")
    private String rating;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public Hours getHours() {
        return hours;
    }

    public Categories[] getCategories() {
        return categories;
    }

    public String getRating() {
        return rating;
    }

    public String getUrl() {
        return url;
    }

    //todo replace with real data
    public String getType() {
        return "Coffee shop";
    }

    public String getAddress() {
        return "B/T W. Broadway & Thompson";
    }

    public String getImageUrl() {
        return "https://ss3.4sqi.net/img/categories_v2/food/coffeeshop_.png";
    }
}
