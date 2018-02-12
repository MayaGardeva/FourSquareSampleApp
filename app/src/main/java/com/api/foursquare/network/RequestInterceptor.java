package com.api.foursquare.network;

import android.support.annotation.NonNull;

import com.api.foursquare.BuildConfig;
import com.api.foursquare.utility.DateUtility;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mayagardeva on 11/02/2018.
 */

@Singleton
public class RequestInterceptor implements Interceptor {

    public static final int MAX_NUMBER_OF_ITEMS_PER_REQUEST = 20;

    @Inject public RequestInterceptor() {}

    @Override public Response intercept(@NonNull Chain chain) throws IOException {

        final String currentDate = DateUtility.getCurrentDateAsString();

        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("client_id", BuildConfig.FOURSQUARE_CLIENT_ID)
                .addQueryParameter("client_secret", BuildConfig.FOURSQUARE_CLIENT_SECRET)
                .addQueryParameter("limit", Integer.toString(MAX_NUMBER_OF_ITEMS_PER_REQUEST))
                .addQueryParameter("v", currentDate)
                .build();

        Request request = original.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
