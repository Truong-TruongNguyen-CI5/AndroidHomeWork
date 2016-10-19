package com.example.nguyen.dailyquote.fragments;


import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyen.dailyquote.FileManager;
import com.example.nguyen.dailyquote.R;
import com.example.nguyen.dailyquote.constants.Constants;
import com.example.nguyen.dailyquote.jsonmodels.QuoteJsonModel;
import com.example.nguyen.dailyquote.main.MainActivity;
import com.example.nguyen.dailyquote.managers.Preferences;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {
    private static final String TAG = QuoteFragment.class.toString() ;
    @BindView(R.id.imv_background)
    ImageView imvBackground;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_username)
    TextView tvUsername;


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void updateQuote(final QuoteJsonModel quoteJsonModel){
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvContent.setText(Html.fromHtml(quoteJsonModel.getContent()));
                tvTitle.setText((quoteJsonModel.getTitle()));
            }
        });
    }

    private void setupUI() {
        //username
        tvUsername.setText("Hi, " + Preferences.getInstance().getUsername());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity()).build();
        ImageLoader.getInstance().init(config);
       // ImageLoader.getInstance().displayImage(Constants.UNPLASH_API, imvBackground);
        final String fileName = "filename";
        File file =  FileManager.getInstance().imageLoadFile(fileName);
        ImageLoader.getInstance().displayImage(Uri.fromFile(file).toString(), imvBackground);
        System.out.println(Uri.fromFile(file));
//        ImageLoader.getInstance().loadImage(Constants.UNPLASH_API, new ImageLoadingListener() {
//            @Override
//            public void onLoadingStarted(String imageUri, View view) {
//            }
//
//            @Override
//            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//            }
//
//            @Override
//            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                FileManager.getInstance().createImage(loadedImage, fileName);
//            }
//
//            @Override
//            public void onLoadingCancelled(String imageUri, View view) {
//            }
//        });

        // Create client
        OkHttpClient client = new OkHttpClient();

        //Create request
        Request request = new Request.Builder().url(Constants.QUOTE_API).build();

        //Send and handle
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                //ket noi that bai
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // ket noi thanh cong
                String bodyString = response.body().string();

                //Create Gson
                Gson gson = new Gson();

                //Parse
                final QuoteJsonModel[] quotes =  gson.fromJson(bodyString, QuoteJsonModel[].class);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvTitle.setText(quotes[0].getTitle());
                        tvContent.setText(quotes[0].getContent());
                    }
                });
            }
        });
    }
}
