package com.example.projectapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {



    private List<DogItem> dogItemList;

    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    private List<DogItem> dogItemListHolder = new ArrayList<DogItem>();



    public RecyclerViewAdapter(Context context, List<DogItem> items, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.dogItemList = items;
        this.onClickListener = onClickListener;
        Filter();
    }

    public void filterDogItemList(){
        dogItemList.remove(dogItemListHolder.get(0));
        dogItemList.remove(dogItemListHolder.get(1));
        dogItemList.remove(dogItemListHolder.get(2));
    }

    public void Filter(){
        dogItemListHolder.add(dogItemList.get(0));
        dogItemListHolder.add(dogItemList.get(2));
        dogItemListHolder.add(dogItemList.get(3));
    }
    public void unFilterDogItemList(){
        dogItemList.add(dogItemListHolder.get(0));
        dogItemList.add(dogItemListHolder.get(1));
        dogItemList.add(dogItemListHolder.get(2));
    }

    @Override
    @NonNull
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        holder.title.setText(dogItemList.get(position).getName());
        holder.textDog.setText("Cost: " + dogItemList.get(position).getCost());
        holder.textPopularity.setText("Popularity: " + dogItemList.get(position).getPopularity());
        holder.itemView.setBackgroundColor(Color.parseColor("#D3D3D3"));
    }


    @Override
    public int getItemCount() {
        return dogItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView textPopularity;
        TextView textDog;
        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
            textDog = itemView.findViewById(R.id.textDog);
            textPopularity = itemView.findViewById(R.id.textPopularityy);

        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(dogItemList.get(getAdapterPosition()));
        }


    }
    public interface OnClickListener{
        void onClick(DogItem item);
    }
}
