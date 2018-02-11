package com.api.foursquare.ui.venues;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.api.foursquare.R;
import com.api.foursquare.ui.custom_views.EndlessRecyclerView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class VenuesActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_view) Toolbar toolbar;
    @BindView(R.id.recycler_view) EndlessRecyclerView recyclerView;
    @BindView(R.id.search_view) MaterialSearchView searchView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_recommendations);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }
}