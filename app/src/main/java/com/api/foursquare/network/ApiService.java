package com.api.foursquare.network;

import com.api.foursquare.network.models.VenueResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public interface ApiService {

    @GET("/v2/venues/explore")
    Observable<VenueResponse> getRecommendedVenues(@Query("near") String near);
}
