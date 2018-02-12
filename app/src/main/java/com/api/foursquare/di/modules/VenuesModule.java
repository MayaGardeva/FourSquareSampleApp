package com.api.foursquare.di.modules;

import android.support.v7.widget.LinearLayoutManager;

import com.api.foursquare.di.scopes.ActivityScope;
import com.api.foursquare.ui.venues.VenuesActivity;
import com.api.foursquare.ui.venues.VenuesAdapter;
import com.api.foursquare.ui.venues.presenter.VenuesPresenter;
import com.api.foursquare.ui.venues.presenter.VenuesPresenterImpl;
import com.api.foursquare.ui.venues.repository.VenuesRepository;
import com.api.foursquare.ui.venues.repository.VenuesRepositoryImpl;
import com.api.foursquare.ui.venues.view.VenuesView;

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
    @ActivityScope VenuesActivity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityScope VenuesView provideView() {
        return view;
    }

    @Provides
    @ActivityScope VenuesRepository provideRepository(VenuesRepositoryImpl repository) {
        return repository;
    }

    @Provides
    @ActivityScope VenuesPresenter providePresenter(VenuesPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @ActivityScope VenuesAdapter provideVenueListAdapter(VenuesActivity venuesActivity) {
        return new VenuesAdapter(venuesActivity);
    }

    @Provides
    @ActivityScope LinearLayoutManager provideLinearLayoutManager(VenuesActivity venuesActivity) {
        return new LinearLayoutManager(venuesActivity);
    }

}
