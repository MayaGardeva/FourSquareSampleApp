package com.api.foursquare.ui.venues;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.api.foursquare.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class VenuesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_venue_poster) ImageView venuePictureView;
    @BindView(R.id.item_venue_title) TextView venueTitleView;
    @BindView(R.id.item_venue_type) TextView venueTypeView;
    @BindView(R.id.item_venue_address) TextView venueAddressView;

    public VenuesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public ImageView getVenuePictureView() {
        return venuePictureView;
    }

    public TextView getVenueTitleView() {
        return venueTitleView;
    }

    public TextView getVenueTypeView() {
        return venueTypeView;
    }

    public TextView getVenueAddressView() { return venueAddressView;}
}
