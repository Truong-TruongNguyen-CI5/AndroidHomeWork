package com.example.nguyen.hw_recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nguyen on 10/25/2016.
 */

public class FoodPlaceViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.im_foodplace)
    ImageView imFoodPlace;
    @BindView(R.id.tv_place)
    TextView tvPlace;

    public FoodPlaceViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void bind(FoodItem foodItem){
        imFoodPlace.setImageResource(foodItem.getImageUrl());
        tvPlace.setText(foodItem.getTitle());
    }
}
