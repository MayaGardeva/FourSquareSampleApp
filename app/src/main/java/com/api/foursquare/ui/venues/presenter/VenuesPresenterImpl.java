package com.api.foursquare.ui.venues.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.api.foursquare.R;
import com.api.foursquare.network.models.VenuesResponse;
import com.api.foursquare.ui.venues.repository.VenuesRepository;
import com.api.foursquare.ui.venues.view.VenuesView;
import com.api.foursquare.utility.NetworkUtility;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class VenuesPresenterImpl implements VenuesPresenter {

    private Disposable subscription;
    private VenuesRepository repository;
    private VenuesView venuesView;
    private Context context;

    @Inject public VenuesPresenterImpl(VenuesRepository repository, Context context) {
        this.repository = repository;
        this.context = context;
    }

    @Override public void getVenuesNear(final String locationName, int page) {
        if (hasDataConnection()) {
            loadMoviesFromNetwork(locationName, page);
        } else {
            onNoDataConnection();
        }
    }

    private void loadMoviesFromNetwork(final String locationName, int page) {
        if (isViewAttached()) {
            venuesView.showProgressBar();
        }
        subscription = repository.getVenuesNear(locationName, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onVenuesSuccess, this::onVenuesFailure);
    }

    @Override public void setVenuesView(VenuesView venuesView) {
        this.venuesView = venuesView;
    }

    @Override public void unSubscribe() {
        if (isViewAttached()) {
            venuesView.hideProgressBar();
        }
        if (subscription != null && !subscription.isDisposed()) {
            subscription.dispose();
        }
    }

    private void onVenuesSuccess(final VenuesResponse venuesResponse) {
        if (isViewAttached()) {
            venuesView.hideProgressBar();
            if (venuesResponse != null) {
                venuesView.showVenues(venuesResponse.getVenues());
            }
        }
    }

    private void onVenuesFailure(Throwable e) {
        if (!hasDataConnection()) {
            onNoDataConnection();
        } else if (e != null && !TextUtils.isEmpty(e.getMessage())) {
            onServerError(e.getMessage());
        } else {
            onGenericError();
        }
    }

    private boolean hasDataConnection() {
        return NetworkUtility.hasNetworkConnection(context);
    }

    private void onGenericError() {
        if (isViewAttached()) {
            venuesView.hideProgressBar();
            venuesView.onError(context.getString(R.string.generic_error));
        }
    }

    private void onServerError(final String message) {
        if (isViewAttached()) {
            venuesView.hideProgressBar();
            venuesView.onError(message);
        }
    }

    private void onNoDataConnection() {
        if (isViewAttached()) {
            venuesView.hideProgressBar();
            venuesView.onError(context.getString(R.string.error_not_connected_to_the_internet));
        }
    }

    private boolean isViewAttached() {
        return venuesView != null;
    }
}
