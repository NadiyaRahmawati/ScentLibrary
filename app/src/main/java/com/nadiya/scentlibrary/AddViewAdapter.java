package com.nadiya.scentlibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nadiya.scentlibrary.databinding.ItemAddBinding;

import java.util.ArrayList;
import java.util.List;

public class AddViewAdapter extends RecyclerView.Adapter<AddViewAdapter.ViewHolder> {
    private List<Add> data = new ArrayList<>();
    private OnItemLongClickListener onItemLongClickListener;

    public void setData (List<Add>data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
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
        holder.itemAddBinding.tvMerekPerfume.setText(add.getMerekPerfume());
        holder.itemAddBinding.tvNamaPerfume.setText(add.getNamaPerfume());
        holder.itemAddBinding.tvDeskripsiPerfume.setText(add.getDeskripsiPerfume());
        holder.itemAddBinding.tvJenisPerfume.setText(add.getJenisPefume());
        holder.itemAddBinding.tvUkuranPerfume.setText(String.valueOf(add.getUkuranPerfume()));
        holder.itemAddBinding.tvHargaPerfume.setText(String.valueOf(add.getHargaPerfume()));
        holder.itemAddBinding.tvGenderPerfume.setText(add.getGenderPerfume());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClickListener.onItemLongClick(v, add, pos);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  ItemAddBinding itemAddBinding;
        public ViewHolder( @NonNull ItemAddBinding itemView) {
            super(itemView.getRoot());
            itemAddBinding = itemView;
        }
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View v, Add add, int position);
    }
}