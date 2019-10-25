package com.example.borgerkong;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;

import java.util.ArrayList;
import android.widget.Toast;

public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.FoodViewHolder> {
    private ArrayList<Food> data;
    private OnDataListener onDataListener;

    public void setData(ArrayList<Food> data, OnDataListener onDataListener) {
        this.data = data;
        this.onDataListener = onDataListener;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public View view;
        public TextView nameText;
        OnDataListener onDataListener;


        public FoodViewHolder(@NonNull View itemView, OnDataListener onDataListener) {
            super(itemView);
            view = itemView;
            nameText = itemView.findViewById(R.id.name);
            this.onDataListener = onDataListener;

            itemView.setOnClickListener(this);

        }

//        public void bind(Food food){
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
////                    Toast.makeText(view.getContext(),"This is a toast", Toast.LENGTH_SHORT).show();
//                    //startActivity(new Intent(FoodRecyclerViewAdapter.this, BigKing.class));
//
//                }
//            });
//            nameText.setText(food.getName());
//
//
//        }

        @Override
        public void onClick(View view) {
            onDataListener.onDataClick(getAdapterPosition());




        }
    }


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()) .inflate(R.layout.food_item, parent, false);

        FoodViewHolder foodViewHolder = new FoodViewHolder(view,onDataListener);

        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        //final Food foodAtPosition = data.get(position);

        Food food = data.get(position);

//        holder.nameText.setText(foodAtPosition.getName());
//
//        holder.view.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Context context = view.getContext();
//
//            Intent intent = new Intent(context, BigKing.class);
//            intent.putExtra("Name", foodAtPosition.getName());
//            context.startActivity(intent);
//
//        }
//
//        });
        holder.nameText.setText(food.getName());
        //holder.bind(food);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnDataListener {
        void onDataClick (int position);
    }
}
