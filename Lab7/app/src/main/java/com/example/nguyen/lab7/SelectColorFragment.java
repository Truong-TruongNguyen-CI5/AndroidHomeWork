package com.example.nguyen.lab7;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectColorFragment extends DialogFragment {


    public SelectColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_select_color, container, false);
        getDialog().getWindow().setLayout(150, 200);
        getDialog().setTitle("Choose color & size");
        return v;
    }

}
