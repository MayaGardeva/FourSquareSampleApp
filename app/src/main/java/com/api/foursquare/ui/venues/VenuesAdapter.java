package com.api.foursquare.ui.venues;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.api.foursquare.R;
import com.api.foursquare.network.models.Venue;
import com.api.foursquare.utility.ImageUtility;

import java.util.List;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class VenuesAdapter extends RecyclerView.Adapter<VenuesViewHolder> {

    private List<Venue> venues;
    private VenuesActivity venuesActivity;

    public VenuesAdapter(VenuesActivity venuesActivity) {
        this.venuesActivity = venuesActivity;
    }

    @Override public VenuesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        VenuesViewHolder viewHolder = new VenuesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.venue_item, parent, false));

        viewHolder.itemView.setOnClickListener(v -> onVenueItemClicked(viewHolder.getAdapterPosition()));
        return viewHolder;
    }

    @Override public void onBindViewHolder(VenuesViewHolder holder, final int position) {
        final Venue venue = venues.get(position);
        
        holder.getVenueTitleView().setText(venue.getName());
        holder.getVenueTypeView().setText(venue.getType());
        holder.getVenueAddressView().setText(Html.fromHtml(venue.getAddress()));
        holder.getVenueStatusView().setText(venue.getHoursStatus());
        setPosterImage(holder, venue.getImageUrl());
    }

    private void setPosterImage(VenuesViewHolder holder, String posterPath) {
        Context context = holder.itemView.getContext();
        ImageUtility.loadImage(posterPath, holder.getVenuePictureView(), context);
    }

    private void onVenueItemClicked(int adapterPosition) {
        if (venues != null && !venues.isEmpty()) {
            venuesActivity.onVenueItemClicked(venues.get(adapterPosition));
        }
    }

    @Override public int getItemCount() {
        return venues == null ? 0 : venues.size();
    }

    public void appendAlbums(List<Venue> venues) {
        if (this.venues == null) {
            this.venues = venues;
        } else {
            this.venues.addAll(venues);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        if (venues != null) {
            venues.clear();
            notifyDataSetChanged();
        }
    }
}
