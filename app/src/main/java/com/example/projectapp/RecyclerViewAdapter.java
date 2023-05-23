package com.example.projectapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {



    private List<DogItem> dogItemList;

    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;




    public RecyclerViewAdapter(Context context, List<DogItem> items, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.dogItemList = items;
        this.onClickListener = onClickListener;
    }

    public List<DogItem> getDogItemList(){
        return dogItemList;
    }

    @Override
    @NonNull
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        holder.title.setText(dogItemList.get(position).getName());
        holder.textDog.setText(dogItemList.get(position).getCost());
    }


    @Override
    public int getItemCount() {
        return dogItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView textDog;



        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
            textDog = itemView.findViewById(R.id.textDog);

        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(dogItemList.get(getAbsoluteAdapterPosition()));
        }


    }
    public interface OnClickListener{
        void onClick(DogItem item);
    }
}
