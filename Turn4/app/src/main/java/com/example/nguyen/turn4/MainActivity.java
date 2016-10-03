package com.example.nguyen.turn4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView lvStoryItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        setupUI();
    }

    public void getReferences() {
        lvStoryItem = (ListView) findViewById(R.id.lv_story_menu);
    }

    private void setupUI() {
        lvStoryItem.setAdapter(new StoryAdapter(this, R.layout.list_item_story, Arrays.asList(StoryItem.ARRY)));
    }
}
