package layout;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nguyen.lab4.MainActivity;
import com.example.nguyen.lab4.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment {

//    @BindView(R.id.im_back3)
//    ImageView imBack3;

    public CFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        ButterKnife.bind(this, view);
        //addListeners();
        return view;
    }

    @Override
    public void onStart() {

        final MainActivity mainActivity = (MainActivity) getActivity();
        ActionBarDrawerToggle toggle = mainActivity.getToggle();
        toggle.setDrawerIndicatorEnabled(false);// Ko hien thi image mac dinh
        toggle.setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_white_24px);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onBackPressed();
            }
        });
        mainActivity.setTitle("Settings");
        mainActivity.showSendMenu(false);
        super.onStart();
    }

//    private void addListeners() {
//        imBack3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.onBackPressed();
//            }
//        });
//    }

}
