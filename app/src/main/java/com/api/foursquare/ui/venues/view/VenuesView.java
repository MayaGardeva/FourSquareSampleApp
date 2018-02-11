package com.api.foursquare.ui.venues.view;

import com.api.foursquare.network.models.Venue;
import com.api.foursquare.ui.MvpView;

import java.util.List;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public interface VenuesView extends MvpView {

    void showVenues(List<Venue> venues);
}
