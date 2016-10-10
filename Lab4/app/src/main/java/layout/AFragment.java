package layout;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nguyen.lab4.MainActivity;
import com.example.nguyen.lab4.R;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {
    ImageView imBack;
    ImageView imShare;

    public AFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_a, container, false);
        imBack = (ImageView) view.findViewById(R.id.im_back);
        imShare = (ImageView) view.findViewById(R.id.im_share) ;
        addListeners();
        return view;
    }
    @Override
    public void onStart() {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.setShowActionBar(false);
        super.onStart();
    }

    private void addListeners() {
        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.onBackPressed();
            }
        });
        imShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, "ABCXYZ");
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
    }
}
