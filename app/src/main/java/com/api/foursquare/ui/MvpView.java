package com.api.foursquare.ui;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public interface MvpView {

    void showProgressBar();

    void hideProgressBar();

    void onError(String message);
}
