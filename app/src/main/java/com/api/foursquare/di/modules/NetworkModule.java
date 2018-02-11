package com.api.foursquare.di.modules;

import com.api.foursquare.BuildConfig;
import com.api.foursquare.network.ApiService;
import com.api.foursquare.network.RequestInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mayagardeva on 11/02/2018.
 */

@Module
public class NetworkModule {
    private static final int TIMEOUT_MS = 30000;

    @Singleton
    @Provides
    Interceptor requestInterceptor(RequestInterceptor interceptor) {
        return interceptor;
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(RequestInterceptor requestInterceptor) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().connectTimeout(TIMEOUT_MS, TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(requestInterceptor)
                .build();
    }

    @Singleton
    @Provides
    Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.FOURSQUARE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    ApiService apiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
