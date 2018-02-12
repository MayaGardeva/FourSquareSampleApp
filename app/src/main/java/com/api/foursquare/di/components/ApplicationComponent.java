package com.api.foursquare.di.components;

import android.content.Context;

import com.api.foursquare.VenuesApplication;
import com.api.foursquare.di.modules.ApplicationModule;
import com.api.foursquare.di.modules.NetworkModule;
import com.api.foursquare.di.modules.VenuesModule;
import com.api.foursquare.di.scopes.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mayagardeva on 11/02/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    @ApplicationContext Context context();

    void inject(VenuesApplication application);

    VenuesComponent plus(VenuesModule venuesModule);
}
