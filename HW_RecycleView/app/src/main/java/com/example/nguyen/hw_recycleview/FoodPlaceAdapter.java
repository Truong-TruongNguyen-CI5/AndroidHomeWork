package com.example.nguyen.hw_recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nguyen on 10/25/2016.
 */

public class FoodPlaceAdapter extends RecyclerView.Adapter<FoodPlaceViewHolder> {
    @Override
    public FoodPlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView =  layoutInflater.inflate(R.layout.list_item_placefood, parent, false);
        FoodPlaceViewHolder foodPlaceViewHolder = new FoodPlaceViewHolder(itemView);
        return foodPlaceViewHolder;
    }

    @Override
    public void onBindViewHolder(FoodPlaceViewHolder holder, int position) {
        FoodItem foodItem = FoodItem.LISTFOOD_SORT.get(position);
        holder.bind(foodItem);
    }

    @Override
    public int getItemCount() {
        return FoodItem.LISTFOOD_SORT.size();
    }
}
