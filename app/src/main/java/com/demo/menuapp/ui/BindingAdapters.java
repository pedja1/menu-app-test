package com.demo.menuapp.ui;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.demo.menuapp.ui.adapter.RecyclerViewBaseAdapter;

import java.util.List;

public class BindingAdapters {
    @BindingAdapter("adapter")
    public static <T> void setAdapter(RecyclerView recyclerView, RecyclerViewBaseAdapter<T> adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("items")
    public static <T> void setItems(RecyclerView recyclerView, List<T> items) {
        if (items != null) {
            RecyclerViewBaseAdapter<T> adapter = (RecyclerViewBaseAdapter<T>) recyclerView.getAdapter();
            if (adapter != null) {
                adapter.setItems(items);
            }
        }
    }

    @BindingAdapter("imageUri")
    public static void setImageUri(ImageView imageView, String uri) {
        Glide.with(imageView.getContext())
                .load(uri)
                .into(imageView);
    }
}
