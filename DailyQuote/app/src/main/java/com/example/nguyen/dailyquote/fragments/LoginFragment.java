package com.example.nguyen.dailyquote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nguyen.dailyquote.R;
import com.example.nguyen.dailyquote.managers.Preferences;
import com.example.nguyen.dailyquote.models.FragmentEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    @BindView(R.id.bt_save)
    Button btSave;
    @BindView(R.id.edt_username)
    EditText edtUsername;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @OnClick(R.id.bt_save)
    public void onClick(View view){
        //Get string form username
        String username = edtUsername.getText().toString();
        // Save data to SharePreferences
        Preferences.getInstance().putUsername(username);
        // Transit to Quote Fragment
        EventBus.getDefault().post(new FragmentEvent(
                new QuoteFragment(),
                false
        ));

    }

}
