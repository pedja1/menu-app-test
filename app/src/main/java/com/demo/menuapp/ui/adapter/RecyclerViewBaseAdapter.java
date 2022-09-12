package com.demo.menuapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.menuapp.BR;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerViewBaseAdapter<T> extends RecyclerView.Adapter<RecyclerViewBaseAdapter.MyViewHolder<T>> {
    static class MyViewHolder<T> extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;
        private final OnItemClickListener<T> onItemClickListener;

        public MyViewHolder(ViewDataBinding binding,
                            OnItemClickListener<T> onItemClickListener) {
            super(binding.getRoot());
            this.binding = binding;
            this.onItemClickListener = onItemClickListener;
        }

        void bind(Object obj) {
            binding.setVariable(BR.obj, obj);
            binding.setVariable(BR.onItemClickListener, onItemClickListener);
            binding.executePendingBindings();
        }
    }

    public interface OnItemClickListener<T> {
        void onItemClicked(T item);
    }

    protected List<T> items = new ArrayList<>();

    private OnItemClickListener<T> onItemClickListener;

    @NonNull
    @Override
    public MyViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new MyViewHolder<>(binding, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder<T> holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutId(position);
    }

    protected abstract int getLayoutId(int position);

    @Override
    public int getItemCount() {
        return items.size();
    }

    public T getItem(int position) {
        return items.get(position);
    }

    public void setItems(List<T> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public OnItemClickListener<T> getOnItemClickListener() {
        return onItemClickListener;
    }
}