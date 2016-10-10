package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyen.lab4.MainActivity;
import com.example.nguyen.lab4.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {
//    @BindView(R.id.im_back2)
//    ImageView imBack2;
//    @BindView(R.id.im_send)
//    ImageView imSend;
    private MainActivity mainActivity ;
    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this,view);
        //addListeners();
        return  view;
    }

    @Override
    public void onStart() {
        mainActivity = (MainActivity) getActivity();
        mainActivity.setTitleActionBar("Pay");
        ActionBarDrawerToggle toggle = mainActivity.getToggle();
        toggle.setDrawerIndicatorEnabled(false);// Ko hien thi image mac dinh
        toggle.setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_white_24px);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onBackPressed();
            }
        });
        mainActivity.showSendMenu(true);
        super.onStart();
    }
    //    private void addListeners() {
//        imBack2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getFragmentManager().popBackStack();
//            }
//        });
//        imSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity dFragment =(MainActivity) getActivity();
//                dFragment.openFragment(new DFragment(), true);
//            }
//        });
//    }

}
