package com.example.nguyen.hw_recycleview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nguyen on 10/24/2016.
 */
public class FoodItem {

    private String title;
    private int imageUrl;

    public FoodItem(String title, int imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public int getImageUrl() {
        return imageUrl;
    }
    public static final FoodItem ARRAY[] = new FoodItem[]{
            new FoodItem("BREAKFIRST",R.drawable.breakfirst),
            new FoodItem("COFFEE", R.drawable.coffee),
            new FoodItem("APPETIZERS", R.drawable.appertizer),
            new FoodItem("DRINKS", R.drawable.drinks),
            new FoodItem("LUNCH", R.drawable.lunch)
    };
    public static final FoodItem ARRAY2[] = new FoodItem[]{
            new FoodItem("American",R.drawable.american),
            new FoodItem("Chinese", R.drawable.chinese),
            new FoodItem("Czech", R.drawable.czech),
            new FoodItem("Italian", R.drawable.italian),
            new FoodItem("Japanese", R.drawable.japanese),
            new FoodItem("Thai", R.drawable.thai)
    };

    public static final List<FoodItem> LISTFOOD = new ArrayList<>(Arrays.asList(ARRAY));
    public static final List<FoodItem> LISTFOOD_SORT = new ArrayList<>(Arrays.asList(ARRAY2));

}
