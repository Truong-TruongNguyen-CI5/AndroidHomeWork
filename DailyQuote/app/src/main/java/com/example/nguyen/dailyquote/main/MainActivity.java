package com.example.nguyen.dailyquote.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.nguyen.dailyquote.R;
import com.example.nguyen.dailyquote.fragments.LoginFragment;
import com.example.nguyen.dailyquote.fragments.QuoteFragment;
import com.example.nguyen.dailyquote.managers.Preferences;
import com.example.nguyen.dailyquote.models.FragmentEvent;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
//        if(Preferences.getInstance().getUsername() == null){
//            changeFragment(new LoginFragment(), false);
//        }
         changeFragment(new QuoteFragment(), false);

//        Storage storage = SimpleStorage.getInternalStorage(this);
//        //storage.createFile("text", "quote.txt", "no pain no gain");
//        String content = storage.readTextFile("text", "quote.txt");
//        Log.d(TAG, String.format("read done: %s", content) );
    }

   @Subscribe
   public void onEvent(FragmentEvent fragmentEvent){
       changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackStack());
   }

    public void changeFragment(Fragment fragment, boolean addToBackStack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,fragment );
        if(addToBackStack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
