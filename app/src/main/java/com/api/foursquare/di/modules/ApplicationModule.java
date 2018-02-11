package com.api.foursquare.di.modules;

import android.app.Application;
import android.content.Context;

import com.api.foursquare.di.scopes.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mayagardeva on 11/02/2018.
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context applicationContext() {
        return application;
    }

    @Provides
    Application application() {
        return application;
    }
}
