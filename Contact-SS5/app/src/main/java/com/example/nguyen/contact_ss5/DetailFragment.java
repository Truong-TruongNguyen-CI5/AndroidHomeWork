package com.example.nguyen.contact_ss5;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements View.OnClickListener {
    private TextView lvTitle;
    private TextView lvNumberPhone;
    private TextView lvWebsite;
    private Contact contact;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        getReferences(view);
        setupUI();
        addListeners();
        return view;
    }

    private void setupUI() {
        lvTitle.setText(contact.getLvTitle());
        lvNumberPhone.setText(contact.getLvNumberPhone());
        lvWebsite.setText(contact.getLvWebsite());
    }

    public void getReferences(View view) {
        lvTitle = (TextView) view.findViewById(R.id.tv_Title);
        lvNumberPhone = (TextView) view.findViewById(R.id.tv_numberPhone);
        lvWebsite = (TextView) view.findViewById(R.id.tv_website);
    }

    public void setContact(Contact contact){
        this.contact = contact;
    }
    private void addListeners() {
        lvWebsite.setOnClickListener(this);
        lvNumberPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(lvWebsite == (TextView) v) {
            String googleSearchString = String.format("%s", contact.getLvWebsite());
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleSearchString));
            startActivity(intent);
        }
        if(lvNumberPhone == (TextView) v){
            String posted_by = contact.getLvNumberPhone();
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + posted_by));
            startActivity(intent);
        }
    }
}
