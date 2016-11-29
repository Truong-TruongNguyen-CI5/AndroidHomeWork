package com.example.nguyen.playermusic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nguyen.playermusic.ItemAlbum;
import com.example.nguyen.playermusic.MediaModel;
import com.example.nguyen.playermusic.MessageEvent;
import com.example.nguyen.playermusic.R;
import com.example.nguyen.playermusic.Service;
import com.example.nguyen.playermusic.manages.NetworkManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.rcv_album)
    RecyclerView rcvAlbum;

    List<ItemAlbum> albumListOffline;
    List<MediaModel> dataArrModels;
    List<MediaModel.Subgenre> mediaModels;
    AlbumAdapter albumAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DBRealm.init(this);
        setupUI();
        getData();
        addListeners();
    }

    private void addListeners() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupUI() {
        albumListOffline = new ArrayList<>();
        dataArrModels = new ArrayList<>();
        mediaModels = new ArrayList<>();
        albumAdapter = new AlbumAdapter();

        tabLayout.addTab(tabLayout.newTab().setText("GENRES"));
        tabLayout.addTab(tabLayout.newTab().setText("PLAY LIST"));
        tabLayout.addTab(tabLayout.newTab().setText("OFFLINE"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        GridLayoutManager manager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position % 3 == 0 ? 2 : 1);
            }
        });


        rcvAlbum.setLayoutManager(manager);

        // setup Adapter

        albumAdapter.notifyDataSetChanged();
        rcvAlbum.setAdapter(albumAdapter);


    }

    public void getData() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://rss.itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        service.result().enqueue(new Callback<List<MediaModel>>() {
            @Override
            public void onResponse(Response<List<MediaModel>> response) {
                Log.d(TAG, String.format("%s", "onRespone"));
                dataArrModels = response.body();
                for (MediaModel mediaModel : dataArrModels) {
                    if (mediaModel.getId().equals("34")) {
                        for (MediaModel.Subgenre subgenre : mediaModel.getSubgenres()) {
                            if (subgenre.getId().equals("")) {
                                subgenre.setId("0");
                            }
                            int id = getResources().getIdentifier("genre_" + subgenre.getId(), "drawable", getPackageName());
                            ItemAlbum.ALBUM_LIST.add(new ItemAlbum(subgenre.getTranslation_key(), id));
                            // Save media type to Realm
                            //Log.d(TAG, String.format("%s %s", subgenre.getTranslation_key(), id));
                        }
                            System.out.println(String.format("ADD %s", ItemAlbum.ALBUM_LIST.size()));
                            DBRealm.getInstance().addList(ItemAlbum.ALBUM_LIST);
                    }
                }
                albumAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, String.format("%s", "onFailure"));
            }
        });

        if(!NetworkManager.isNetworkConnected(this)){
            if(DBRealm.getInstance().getAllItemAlbum().size()!=0){
                ItemAlbum.ALBUM_LIST = DBRealm.getInstance().getAllItemAlbum();
            }
            albumAdapter.notifyDataSetChanged();
            rcvAlbum.setAdapter(albumAdapter);
        }
    }

    public void changeTabFragment(Fragment fragment, boolean addToBackstack, String tag) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_contatiner, fragment);
        if (addToBackstack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    public void changeFragment(Fragment fragment, boolean addToBackstack, String tag) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main, fragment);
        if (addToBackstack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void changeActivity(Activity activity, int position){
        Intent intent = new Intent(MainActivity.this, activity.getClass());
        intent.putExtra("POSITION", position);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        changeActivity(event.getActivity(), event.getPosition());
    }

}
