package com.example.nguyen.hw_recycleview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nguyen on 10/24/2016.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {
    public static final String TAG = FoodAdapter.class.toString();


    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView =  layoutInflater.inflate(R.layout.list_item_food, parent, false);
        FoodViewHolder foodViewHolder = new FoodViewHolder(itemView);
        Log.d(TAG,"On Create" );
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        FoodItem foodItem = FoodItem.LISTFOOD.get(position);
        holder.bind(foodItem);
    }

    @Override
    public int getItemCount() {
        return FoodItem.LISTFOOD.size();
    }
}
