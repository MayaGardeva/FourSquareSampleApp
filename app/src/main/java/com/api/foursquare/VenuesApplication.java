package com.api.foursquare;

import android.app.Application;

import com.api.foursquare.di.components.ApplicationComponent;
import com.api.foursquare.di.components.DaggerApplicationComponent;
import com.api.foursquare.di.modules.ApplicationModule;
import com.api.foursquare.di.modules.NetworkModule;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class VenuesApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();

        applicationComponent = createApplicationComponent();
        applicationComponent.inject(this);
    }

    private ApplicationComponent createApplicationComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
