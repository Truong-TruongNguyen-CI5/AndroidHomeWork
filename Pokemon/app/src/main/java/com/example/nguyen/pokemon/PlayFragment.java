package com.example.nguyen.pokemon;


import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.im_backtoplay)
    ImageView imBackToPlay;
    @BindView(R.id.pr_time)
    ProgressBar prTime;
    private int progress =100;
    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_play, container, false);
        ButterKnife.bind(this, v);
        addListeners();
        setupUI();
        return v;
    }



    private void setupUI() {

              Thread thread = new Thread(new Runnable() {
                  @Override
                  public void run() {

                      prTime.setProgress(100);
                      while(prTime.getProgress() > 0){
                          try {
                              progress -= 1;
                              Thread.sleep(100);
                              prTime.setProgress(progress);
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                  }
              });
        thread.start();

    }

    private void addListeners() {
        imBackToPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if((ImageView) v == imBackToPlay){
            getActivity().onBackPressed();
        }
    }
}
