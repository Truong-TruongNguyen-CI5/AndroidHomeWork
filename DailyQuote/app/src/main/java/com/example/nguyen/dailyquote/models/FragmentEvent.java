package com.example.nguyen.dailyquote.models;

import android.support.v4.app.Fragment;

/**
 * Created by Nguyen on 10/12/2016.
 */

public class FragmentEvent {
    private Fragment fragment;
    private boolean addToBackStack;

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public boolean isAddToBackStack() {
        return addToBackStack;
    }

    public void setAddToBackStack(boolean addToBackStack) {
        this.addToBackStack = addToBackStack;
    }

    public FragmentEvent(Fragment fragment, boolean addToBackStack) {

        this.fragment = fragment;
        this.addToBackStack = addToBackStack;
    }
}
