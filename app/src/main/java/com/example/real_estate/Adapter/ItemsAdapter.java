package com.example.real_estate.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.real_estate.Activity.DetailActivity2;
import com.example.real_estate.Domain.PropertyDomain;
import com.example.real_estate.databinding.ViewholderItemBinding;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.Viewholder> {
    ArrayList<PropertyDomain> items;
    Context context;
    ViewholderItemBinding binding;

    public ItemsAdapter(ArrayList<PropertyDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemsAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        context =parent.getContext();
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, @SuppressLint("RecyclerView") int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.priceTxt.setText("$"+items.get(position).getPrice());
        binding.typeTxt.setText(items.get(position).getType());
        binding.scoreTxt.setText(""+items.get(position).getScore());
        binding.addressTxt.setText(items.get(position).getAddress());
        binding.bedTxt.setText(""+items.get(position).getBed());
        binding.bathTxt.setText(""+items.get(position).getBath());


        int drawableResourceId=holder.itemView.getResources()
                .getIdentifier(items.get(position).getPickPath(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(binding.pic);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(context, DetailActivity2.class);
               intent.putExtra("object",items.get(position));
               context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderItemBinding binding) {
            super(binding.getRoot());
        }
    }
}
