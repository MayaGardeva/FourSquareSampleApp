package com.api.foursquare.ui.venues.repository;


import com.api.foursquare.network.ApiService;
import com.api.foursquare.network.models.VenuesResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class VenuesRepositoryImpl implements VenuesRepository {

    private ApiService apiService;

    @Inject public VenuesRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override public Observable<VenuesResponse> getVenuesNear(final String locationName) {
        return apiService.getRecommendedVenuesNear(locationName);
    }
}
