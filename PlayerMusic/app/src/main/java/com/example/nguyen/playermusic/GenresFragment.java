package com.example.nguyen.playermusic;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nguyen.playermusic.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nguyen on 11/26/2016.
 */

public class GenresFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_genres, container, false);
        return v;
    }
}
