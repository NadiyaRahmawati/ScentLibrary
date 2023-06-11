package com.nadiya.scentlibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NonNls;

import java.util.ArrayList;
import java.util.List;

public class AddViewAdapter extends RecyclerView.Adapter<AddViewAdapter.ViewHolder> {
    private List<Add> data = new ArrayList<>();

    public void setData(List<Add> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AddViewAdapter.ViewHolderonCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerView.ViewHolder(AddViewAdapter.inflate(LayoutInflater.from(parent.getContext(), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AddViewAdapter.ViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();
        Add add = data.get(pos);
        holder.AddViewAdapter.tv_Username.setText(add.getUsername());
        holder.AddViewAdapter.tv_createdDate.setText(add.getCreated_date());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AddViewAdapter addViewAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView.getRootView());
            AddViewAdapter = itemView;
        }

    }