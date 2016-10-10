package layout;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class DFragment extends Fragment {
    @BindView(R.id.im_ok)
    ImageView imOk;

    public DFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_d, container, false);
        ButterKnife.bind(this, view);
        addListeners();
        return view;
    }

    @Override
    public void onStart() {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.showSendMenu(false);
        super.onStart();
    }

    private void addListeners() {
        imOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}