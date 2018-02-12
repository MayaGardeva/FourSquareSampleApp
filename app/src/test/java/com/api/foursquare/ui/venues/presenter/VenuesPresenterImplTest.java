package com.api.foursquare.ui.venues.presenter;


import android.content.Context;
import android.text.TextUtils;

import com.api.foursquare.R;
import com.api.foursquare.RxSchedulerRule;
import com.api.foursquare.network.models.Venue;
import com.api.foursquare.network.models.VenuesResponse;
import com.api.foursquare.ui.venues.repository.VenuesRepository;
import com.api.foursquare.ui.venues.view.VenuesView;
import com.api.foursquare.utility.NetworkUtility;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by mayagardeva on 12/02/2018.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({NetworkUtility.class, TextUtils.class})
public class VenuesPresenterImplTest {

    @Mock private VenuesRepository repository;
    @Mock private Context context;
    @Mock private VenuesView view;
    @Mock private VenuesResponse venuesResponse;
    @Mock private List<Venue> venueList;
    @Rule public RxSchedulerRule rxSchedulerRule = new RxSchedulerRule();

    private String venueName;
    private int page;
    private VenuesPresenterImpl venuesPresenter;

    @Before public void setUp() {
        venuesPresenter = new VenuesPresenterImpl(repository, context);
        PowerMockito.mockStatic(NetworkUtility.class);
        PowerMockito.mockStatic(TextUtils.class);
        venueName = "Holborn";
        page = 1;
    }

    @Test public void getVenuesSuccess() {
        Observable<VenuesResponse> venuesResponseObservable = Observable.just(venuesResponse);

        when(NetworkUtility.hasNetworkConnection(context)).thenReturn(true);
        when(repository.getVenuesNear(venueName, page)).thenReturn(venuesResponseObservable);
        when(venuesResponse.getVenues()).thenReturn(venueList);

        venuesPresenter.setVenuesView(view);
        venuesPresenter.getVenuesNear(venueName, page);

        verify(view).showProgressBar();
        verify(view).showVenues(venueList);
        verify(view).hideProgressBar();
    }

    @Test public void getVenuesFailure() {
        final String errorMessage = "timeout";
        Observable<VenuesResponse> venuesResponseObservable = Observable.error(new TimeoutException(errorMessage));

        when(NetworkUtility.hasNetworkConnection(context)).thenReturn(true);
        when(repository.getVenuesNear(venueName, page)).thenReturn(venuesResponseObservable);

        venuesPresenter.setVenuesView(view);
        venuesPresenter.getVenuesNear(venueName, page);

        verify(view).showProgressBar();
        verify(view).onError(errorMessage);
        verify(view).hideProgressBar();
    }

    @Test public void getVenuesNoDataConnection() {
        final String noDataConnection = "no data connection";
        when(NetworkUtility.hasNetworkConnection(context)).thenReturn(false);
        when(context.getString(R.string.error_not_connected_to_the_internet)).thenReturn(noDataConnection);

        venuesPresenter.setVenuesView(view);
        venuesPresenter.getVenuesNear(venueName, page);

        verify(view).onError(noDataConnection);
        verify(view).hideProgressBar();
    }

    @Test public void getVenuesGenericError() {
        final String genericError = "generic error message";
        TimeoutException timeoutException = new TimeoutException();
        Observable<VenuesResponse> venuesResponseObservable = Observable.error(timeoutException);

        when(NetworkUtility.hasNetworkConnection(context)).thenReturn(true);
        when(TextUtils.isEmpty(timeoutException.getMessage())).thenReturn(true);
        when(context.getString(R.string.generic_error)).thenReturn(genericError);
        when(repository.getVenuesNear(venueName, page)).thenReturn(venuesResponseObservable);

        venuesPresenter.setVenuesView(view);
        venuesPresenter.getVenuesNear(venueName, page);

        verify(view).showProgressBar();
        verify(view).onError(genericError);
        verify(view).hideProgressBar();
    }

    @Test public void getVenuesServerError() {
        final String errorMessage = "timeout";
        TimeoutException timeoutException = new TimeoutException(errorMessage);
        Observable<VenuesResponse> venuesErrorResponseObservable = Observable.error(timeoutException);

        when(NetworkUtility.hasNetworkConnection(context)).thenReturn(true);
        when(TextUtils.isEmpty(timeoutException.getMessage())).thenReturn(false);
        when(repository.getVenuesNear(venueName, page)).thenReturn(venuesErrorResponseObservable);

        venuesPresenter.setVenuesView(view);
        venuesPresenter.getVenuesNear(venueName, page);

        verify(view).showProgressBar();
        verify(view).onError(errorMessage);
        verify(view).hideProgressBar();
    }

    @After public void tearDown() {
        venuesPresenter.unSubscribe();
    }
}
