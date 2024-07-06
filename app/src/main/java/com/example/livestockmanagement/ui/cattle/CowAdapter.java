package com.example.livestockmanagement.ui.cattle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livestockmanagement.R;

import java.util.List;

public class CowAdapter extends RecyclerView.Adapter<CowAdapter.CowViewHolder> {
    private List<Cow> cowList;

    public CowAdapter(List<Cow> cowList) {
        this.cowList = cowList;
    }

    @Override
    public CowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cow, parent, false);
        return new CowViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CowViewHolder holder, int position) {
        Cow cow = cowList.get(position);
        holder.name.setText(cow.getName());
        holder.tag.setText(cow.getTagNumber());
        holder.breed.setText(cow.getBreed());
        holder.purpose.setText(cow.getPurpose());
    }

    @Override
    public int getItemCount() {
        return cowList.size();
    }

    public class CowViewHolder extends RecyclerView.ViewHolder {
        public TextView name, tag, breed, purpose;

        public CowViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.cow_name);
            tag = view.findViewById(R.id.tag);
            breed = view.findViewById(R.id.text_breed);
            purpose = view.findViewById(R.id.text_purpose);
        }
    }
}

