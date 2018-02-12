package com.api.foursquare.ui.venues;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.api.foursquare.R;
import com.api.foursquare.VenuesApplication;
import com.api.foursquare.di.modules.VenuesModule;
import com.api.foursquare.network.models.Venue;
import com.api.foursquare.ui.custom_views.EndlessRecyclerView;
import com.api.foursquare.ui.venues.presenter.VenuesPresenter;
import com.api.foursquare.ui.venues.view.VenuesView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class VenuesActivity extends AppCompatActivity implements VenuesView {

    @Inject VenuesPresenter venuesPresenter;
    @Inject VenuesAdapter venuesAdapter;
    @Inject LinearLayoutManager linearLayoutManager;

    @BindView(R.id.toolbar_view) Toolbar toolbar;
    @BindView(R.id.recycler_view) EndlessRecyclerView recyclerView;
    @BindView(R.id.search_view) MaterialSearchView searchView;
    @BindView(R.id.progress_bar) ProgressBar progressBar;

    private final static String DEFAULT_SEARCH_VALUE = "Holborn";
    private final static int DEFAULT_PAGE_NUMBER = 1;
    private int currentPageNumber = DEFAULT_PAGE_NUMBER;
    private String inputValue = DEFAULT_SEARCH_VALUE;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_recommendations);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        injectDependencies();
        setupVenuesRecyclerView();
        setupSearchView();
        loadDefaultVenues();
    }

    private void injectDependencies() {
        ((VenuesApplication) this.getApplication()).getApplicationComponent().plus(new VenuesModule(this, this)).inject(this);
    }

    private void setupVenuesRecyclerView() {
        recyclerView.setAdapter(venuesAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setOnLoadMoreListener(() -> {
            if (!TextUtils.isEmpty(inputValue)) {
                venuesPresenter.getVenuesNear(inputValue, currentPageNumber);
                currentPageNumber++;
            }
        });
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String query) {
                getVenuesForQuery(query);
                return true;
            }

            @Override public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override public void onSearchViewShown() {
                inputValue = "";
                resetAlbumsListView();
            }

            @Override public void onSearchViewClosed() {
                getVenuesForQuery(DEFAULT_SEARCH_VALUE);
            }
        });
    }

    private void loadDefaultVenues() {
        venuesPresenter.setVenuesView(this);
        venuesPresenter.getVenuesNear(inputValue, currentPageNumber);
        currentPageNumber++;
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        venuesPresenter.unSubscribe();
    }

    @Override public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

    private void getVenuesForQuery(final String query) {
        resetAlbumsListView();
        inputValue = query;
        venuesPresenter.getVenuesNear(query, currentPageNumber);
        currentPageNumber++;
    }

    private void resetAlbumsListView() {
        venuesAdapter.clear();
        currentPageNumber = DEFAULT_PAGE_NUMBER;
    }

    @Override public void showVenues(List<Venue> venues) {
        recyclerView.setLoading(false);
        venuesAdapter.appendAlbums(venues);
    }

    public void onVenueItemClicked(Venue venue) {
        showSnackBar(venue.getName());
    }

    @Override public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override public void onError(String message) {
        recyclerView.setLoading(false);
        showSnackBar(message);
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        View snackBarView = snackbar.getView();
        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }
}