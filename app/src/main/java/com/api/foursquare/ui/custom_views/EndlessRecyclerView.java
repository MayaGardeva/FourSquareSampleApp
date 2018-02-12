package com.api.foursquare.ui.custom_views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class EndlessRecyclerView extends RecyclerView {
    private AdvancedEndlessRecyclerOnScrollListener onScrollListener;

    public EndlessRecyclerView(Context context) {
        super(context);
    }

    public EndlessRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EndlessRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override public void setLayoutManager(LayoutManager layout) {
        if (!(layout instanceof LinearLayoutManager)) {
            throw new RuntimeException();
        }

        onScrollListener = new AdvancedEndlessRecyclerOnScrollListener(layout) {
            @Override public void onLoadMore() {
                if (onLoadMoreListener != null) {
                    onLoadMoreListener.onLoadMore();
                }
            }
        };

        addOnScrollListener(onScrollListener);
        super.setLayoutManager(layout);
    }

    private onLoadMoreListener onLoadMoreListener;

    public void setOnLoadMoreListener(EndlessRecyclerView.onLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface onLoadMoreListener {
        void onLoadMore();
    }

    public void setLoading(boolean enable) {
        this.onScrollListener.setLoading(enable);
    }

    public abstract class AdvancedEndlessRecyclerOnScrollListener extends OnScrollListener {
        private int visibleThreshold = 2;
        private int lastVisibleItem, totalItemCount;
        private boolean loading;
        private LayoutManager linearLayoutManager;

        public AdvancedEndlessRecyclerOnScrollListener(LayoutManager linearLayoutManager) {
            this.linearLayoutManager = linearLayoutManager;
        }

        @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            totalItemCount = linearLayoutManager.getItemCount();
            lastVisibleItem = ((LinearLayoutManager) linearLayoutManager).findLastVisibleItemPosition();

            if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                loading = true;
                onLoadMore();
            }
        }

        public void setLoading(boolean enable) {
            this.loading = enable;
        }

        public abstract void onLoadMore();
    }
}