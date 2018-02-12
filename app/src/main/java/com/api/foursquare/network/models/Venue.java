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

    @SerializedName("photos")
    private Photos photos;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getRating() {
        return rating;
    }

    public String getType() {
        if (categories != null && categories.length > 0) {
            return categories[0].getName();
        } else {
            return "***No data available***";
        }
    }

    public String getAddress() {
        StringBuilder locationStr = new StringBuilder();
        if (location != null) {
            for (String line : location.getFormattedAddress()) {
                locationStr.append(line).append("<br/>");
            }
        }
        return locationStr.toString();
    }

    public String getImageUrl() {
        if (photos != null) {
            PhotoGroups[] photoGroups = photos.getGroups();
            if (photoGroups != null && photoGroups.length > 0) {
                PhotoGroups photoGroup = photoGroups[0];
                PhotoItems[] photoItems = photoGroup.getItems();
                if (photoItems != null && photoItems.length > 0) {
                    PhotoItems photoItem = photoItems[0];
                    if (photoItem != null && photoItem.getUrl() != null) {
                        return photoItem.getUrl();
                    }
                }
            }
        }

        return "";
    }

    public String getHoursStatus() {
        if (hours != null) {
            return hours.getStatus();
        } else {
            return "";
        }
    }
}
