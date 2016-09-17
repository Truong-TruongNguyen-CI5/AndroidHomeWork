package techkids.vn.homeworks3_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NodeDetail extends AppCompatActivity {
    private static final String TAG = NodeDetail.class.toString();
    private Intent intent;
    private int position;
    private String title;
    EditText etTitle;
    EditText etContent;
    Button btSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_detail);
        getReferred();
        setupUI();
        addListener();
    }

    private void setupUI() {
        intent = getIntent();
        position = intent.getIntExtra("POSITION", -1);
        title = intent.getStringExtra("STRING");
        if (position != -1) {
            etTitle.setText(title);
            etContent.setText(MainActivity.contentArrayList.get(position));
        }
    }
    private void addListener() {
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position != -1) onSave();
                else {
                    MainActivity.nodeArrayList.add(etTitle.getText().toString());
                    MainActivity.nodeListAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void onSave(){
        if(position!= -1){
            MainActivity.contentArrayList.set(position,etContent.getText().toString());
        }

    }

    public void getReferred() {
        etTitle = (EditText) findViewById(R.id.et_title);
        etContent = (EditText) findViewById(R.id.et_content);
        btSave = (Button) findViewById(R.id.bt_save);
    }
}
