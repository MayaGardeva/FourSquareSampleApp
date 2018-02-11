package com.api.foursquare.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class Venue {

    @SerializedName("name")
    private String name;


    public String getName() {
        return name;
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
