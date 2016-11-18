package com.example.nguyen.pokemon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.im_gen1)
    ImageView imGen1;
    @BindView(R.id.im_gen2)
    ImageView imGen2;
    @BindView(R.id.im_gen3)
    ImageView imGen3;
    @BindView(R.id.im_gen4)
    ImageView imGen4;
    @BindView(R.id.im_gen5)
    ImageView imGen5;
    @BindView(R.id.im_gen6)
    ImageView imGen6;
    @BindView(R.id.im_backtoplay)
    ImageView imBackToPlay;

    private ArrayList<ImageView> imageViews;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this, v);
        init();
        addListeners();
        return v;
    }

    private void init() {
        imageViews = new ArrayList<>();
        imageViews.add(imGen1);
        imageViews.add(imGen2);
        imageViews.add(imGen3);
        imageViews.add(imGen4);
        imageViews.add(imGen5);
        imageViews.add(imGen6);
    }

    private void addListeners() {
        imBackToPlay.setOnClickListener(this);
        for(ImageView imageView : imageViews){
            imageView.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        for (ImageView imageView : imageViews){
            if((ImageView) v == imageView){
                if(imageView.getAlpha() == 0.5){
                    imageView.setAlpha((float) 1.0);
                }
                else{
                    imageView.setAlpha((float) 0.5);
                }
            }
        }
        if((ImageView) v == imBackToPlay){
             getActivity().onBackPressed();
        }
    }

}
