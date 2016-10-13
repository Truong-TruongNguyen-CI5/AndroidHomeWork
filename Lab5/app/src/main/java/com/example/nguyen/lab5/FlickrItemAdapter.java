package com.example.nguyen.lab5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nguyen on 10/13/2016.
 */

public class FlickrItemAdapter extends ArrayAdapter {
   @BindView(R.id.tv_title)
   TextView tvTitle;
    @BindView(R.id.tv_link)
    TextView tvLink;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.im_item)
    ImageView imItem;


    public FlickrItemAdapter(Context context, int resource, List<FlickrItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
        }
        FlickrItem flickrItem = (FlickrItem) getItem(position);
        ButterKnife.bind(this, convertView);
        tvTitle.setText(flickrItem.getTitle());
        tvLink.setText(flickrItem.getLink());
        tvDate.setText(flickrItem.getDateTaken());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getContext()).build();
        ImageLoader.getInstance().init(config);
        ImageLoader.getInstance().displayImage(flickrItem.getLink(), imItem);
        return convertView;
    }
}
