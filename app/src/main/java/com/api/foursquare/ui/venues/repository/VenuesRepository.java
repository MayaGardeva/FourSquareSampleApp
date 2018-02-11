package com.api.foursquare.ui.venues.repository;


import com.api.foursquare.network.models.VenuesResponse;

import io.reactivex.Observable;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public interface VenuesRepository {
    Observable<VenuesResponse> getVenuesNear(final String locationName, int offset);
}
