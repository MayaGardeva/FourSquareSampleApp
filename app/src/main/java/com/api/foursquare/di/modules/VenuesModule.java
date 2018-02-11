package com.api.foursquare.di.modules;

import com.api.foursquare.VenuesActivity;
import com.api.foursquare.di.scopes.ActivityScope;
import com.api.foursquare.ui.venues.VenuesView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mayagardeva on 11/02/2018.
 */

@Module
public class VenuesModule {

    private VenuesActivity activity;
    private VenuesView view;

    public VenuesModule(VenuesActivity activity, VenuesView view) {
        this.activity = activity;
        this.view = view;
    }

    @Provides
    @ActivityScope
    VenuesActivity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    VenuesView provideView() {
        return view;
    }

}
