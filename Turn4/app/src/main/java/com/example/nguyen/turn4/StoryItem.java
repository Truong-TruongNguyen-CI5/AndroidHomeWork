package com.example.nguyen.turn4;

/**
 * Created by Nguyen on 10/2/2016.
 */

public class StoryItem {
    private String time;
    private String context;
    private int imageResId;

    public static final StoryItem ARRY [] = new StoryItem[]{
            new StoryItem("He may act like he wants a secretary but most of the time they’re looking for…\n", R.drawable.item1, "2 minutes ago..."),
            new StoryItem("Peggy, just think about it. Deeply. Then forget it. And an idea will jump up on your face", R.drawable.item2, "4 minutes ago..."),
            new StoryItem("Go home, take a paper bag and cut some eyeholes out of it. Put it over your head\n", R.drawable.item3, "1 minutes ago..."),
            new StoryItem("Get out of here and move forward. This never happened. It will shock you how much\n", R.drawable.item4, "8 minutes ago..."),
            new StoryItem("That poor girl. She doesn’t know that loving you is the worst way to get you", R.drawable.item5, "8 minutes ago...")
    };

    public StoryItem(String context, int imageResId, String time) {
        this.context = context;
        this.imageResId = imageResId;
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
