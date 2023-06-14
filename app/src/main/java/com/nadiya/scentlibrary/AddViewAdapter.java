package com.nadiya.scentlibrary;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nadiya.scentlibrary.databinding.ItemAddBinding;

import java.util.ArrayList;
import java.util.List;

public class AddViewAdapter extends RecyclerView.Adapter<AddViewAdapter.ViewHolder> {
    private List<Add> data = new ArrayList<>();

    public void setData (List<Add>data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AddViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemAddBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AddViewAdapter.ViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();
        Add add = data.get(pos);
        holder.itemAddBinding.

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull @NonNull ItemAddBinding itemView) {
            super(itemView);
        }
    }
}