package com.example.nguyen.contact_ss5;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.List;

public class ContactListActivity extends AppCompatActivity {
    private ListView lvContact;
    public static List<Contact> contactList;
    private FrameLayout frameLayoutList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        initData();
        getReferences();
        setupUI();
        addListenners();
    }

    private void initData() {
        contactList = Contact.getContactList();
    }

    public void getReferences() {
        lvContact = (ListView) findViewById(R.id.lv_Contact);
        frameLayoutList = (FrameLayout) findViewById(R.id.fl_container_list);
    }

    private void setupUI() {
        ArrayAdapter contactAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                contactList);
        lvContact.setAdapter(contactAdapter);
    }

    private void addListenners() {
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Contact contact = contactList.get(position);
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setContact(contact);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(frameLayoutList != null){
                    fragmentTransaction.replace(R.id.fl_container_list, detailFragment);
                }
                else {
                    fragmentTransaction.replace(R.id.fl_container, detailFragment);
                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
    }
}
