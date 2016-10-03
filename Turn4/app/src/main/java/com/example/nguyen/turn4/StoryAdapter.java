package com.example.nguyen.turn4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nguyen on 10/2/2016.
 */

public class StoryAdapter extends ArrayAdapter<StoryItem> {
    private TextView tvTitle;
    ImageView ivStory;
    TextView tvTime;
    public StoryAdapter(Context context, int resource, List<StoryItem> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());

        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.list_item_story, parent, false);

        TextView tvTitle =(TextView) convertView.findViewById(R.id.tv_line);
        ImageView ivFashion = (ImageView) convertView.findViewById(R.id.iv_story_item);
        TextView tvTime = (TextView) convertView.findViewById(R.id.tv_time);

        tvTitle.setText(getItem(position).getContext());
        tvTime.setText(getItem(position).getTime());
        ivFashion.setImageResource(getItem(position).getImageResId());

        return convertView;
    }
}
