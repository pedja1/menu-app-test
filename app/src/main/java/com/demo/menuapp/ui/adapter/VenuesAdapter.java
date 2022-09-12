package com.demo.menuapp.ui.adapter;

import com.demo.menuapp.R;
import com.demo.menuapp.ui.view.VenueViewItem;

public class VenuesAdapter extends RecyclerViewBaseAdapter<VenueViewItem> {
    @Override
    protected int getLayoutId(int position) {
        return R.layout.layout_item_venue;
    }
}
