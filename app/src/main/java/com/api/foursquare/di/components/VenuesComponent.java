package com.api.foursquare.di.components;


import com.api.foursquare.di.modules.VenuesModule;
import com.api.foursquare.di.scopes.ActivityScope;
import com.api.foursquare.ui.venues.VenuesActivity;

import dagger.Subcomponent;

/**
 * Created by mayagardeva on 11/02/2018.
 */

@ActivityScope
@Subcomponent(modules = {VenuesModule.class})
public interface VenuesComponent {

    void inject(VenuesActivity activity);
}
