package com.example.nguyen.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString() ;

    @BindView(R.id.lv_detail)
    ListView lvDetail;
    private ArrayAdapter<FlickrItem> modelArrayAdapter;
    private ArrayList<FlickrItem> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getData();
        setupUI();
    }

    private void setupUI() {
        modelArrayAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.list_item,
                modelArrayList);
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
//        ImageLoader.getInstance().init(config);
//        ImageLoader.getInstance().displayImage(Constants.UNPLASH_API, imvBackground);
    }

    public void getData() {
        modelArrayList = new ArrayList<>();
        // Create client
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constants.IMAGE_LINK).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bodyString = response.body().string()
                        .replace("jsonFlickrFeed(", "")
                        .replace("})", "}");
//                Gson gson = new Gson();
//                final QuoteJsonModel quotes[] =  gson.fromJson(bodyString, QuoteJsonModel[].class);

                 final FlickrFeed flickrFeed = new Gson().fromJson(bodyString, FlickrFeed.class);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        for(QuoteJsonModel quoteJsonModel: quotes){
//                            modelArrayList.add(quoteJsonModel);
//                            Log.d(TAG, String.format("%s", quoteJsonModel));
//                        }
                        for(FlickrItem item : flickrFeed.getItems()){
                            modelArrayList.add(item);
                            System.out.println(item.getDateTaken());

                        }
                        modelArrayAdapter.notifyDataSetChanged();
                        lvDetail.setAdapter(new FlickrItemAdapter(MainActivity.this,R.layout.list_item, modelArrayList));
                    }
                });
            }
        });
    }
}
