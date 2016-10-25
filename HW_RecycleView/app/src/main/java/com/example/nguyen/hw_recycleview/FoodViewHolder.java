package com.example.nguyen.hw_recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nguyen on 10/24/2016.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.im_content)
    ImageView imContent;

    public FoodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void bind(FoodItem foodItem){
        tvTitle.setText(foodItem.getTitle());
        imContent.setImageResource(foodItem.getImageUrl());
    }
}
