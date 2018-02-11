package com.api.foursquare.utility;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.api.foursquare.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class ImageUtility {

    public static void loadImage(final String posterPath, ImageView imageView, Context context) {
        if (!TextUtils.isEmpty(posterPath)) {
            glideDrawable(posterPath, context).into(imageView);
        } else {
            imageView.setImageResource(R.drawable.ic_placeholder);
        }
    }

    private static RequestBuilder glideDrawable(final String url, Context context) {
        return Glide
                .with(context)
                .setDefaultRequestOptions(getRequestOptions())
                .load(url);
    }

    private static RequestOptions getRequestOptions() {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_placeholder);
        requestOptions.error(R.drawable.ic_placeholder);
        requestOptions.centerCrop();

        return requestOptions;
    }

    public static void initImageLoader(Context context) {
        Glide.get(context).setMemoryCategory(MemoryCategory.LOW);
    }
}
