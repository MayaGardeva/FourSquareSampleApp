package com.api.foursquare.ui.venues.presenter;

import com.api.foursquare.ui.MvpPresenter;
import com.api.foursquare.ui.venues.view.VenuesView;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public interface VenuesPresenter extends MvpPresenter {

    void getVenuesNear(final String locationName);

    void setVenuesView(VenuesView venuesView);
}
