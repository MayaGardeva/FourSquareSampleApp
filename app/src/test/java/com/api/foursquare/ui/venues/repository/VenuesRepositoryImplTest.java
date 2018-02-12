package com.api.foursquare.ui.venues.repository;

import com.api.foursquare.network.ApiService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.api.foursquare.network.RequestInterceptor.MAX_NUMBER_OF_ITEMS_PER_REQUEST;
import static org.mockito.Mockito.verify;

/**
 * Created by mayagardeva on 12/02/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class VenuesRepositoryImplTest {

    @Mock private ApiService apiService;

    private VenuesRepositoryImpl repository;
    private String venueName;
    private int page;

    @Before public void setUp() {
        repository = new VenuesRepositoryImpl(apiService);
        venueName = "Holborn";
        page = 1;
    }

    @Test
    public void getVenuesTest() {
        repository.getVenuesNear(venueName, page);

        verify(apiService).getRecommendedVenuesNear(venueName, page * MAX_NUMBER_OF_ITEMS_PER_REQUEST);
    }
}
