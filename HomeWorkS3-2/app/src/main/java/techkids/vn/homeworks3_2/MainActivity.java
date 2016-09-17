package techkids.vn.homeworks3_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> contentArrayList = new ArrayList<>();
    public static ListView lvNode;
    private Button btAdd;

    private static String[] nodeList = new String[]{
            "Tools for learning Android","View", "Activity","Fragment "
    };
    public static ArrayList<String> nodeArrayList = new ArrayList<>(Arrays.asList(nodeList));
    public static ArrayAdapter<String> nodeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferred();
        setupUI();
        addListenner();
    }

    public void getReferred() {
        lvNode = (ListView) findViewById(R.id.lv_node);
        btAdd = (Button) findViewById(R.id.bt_add);
    }

    private void setupUI() {
        nodeListAdapter = new ArrayAdapter<String>(this,R.layout.simple_list_item,nodeArrayList);
        lvNode.setAdapter(nodeListAdapter);
        final String[] contents = new String[]{
                "Android studio",
                "life cycle",
                "Layout",
                "Write Something",
                "",
        };
        contentArrayList.addAll(Arrays.asList(contents));
    }

    private void addListenner() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NodeDetail.class);
                startActivity(intent);
            }
        });
        lvNode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, NodeDetail.class);
                intent.putExtra("POSITION", i);
                intent.putExtra("STRING", nodeArrayList.get(i));
                startActivity(intent);
            }
        });
        lvNode.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                nodeArrayList.remove(i);
                nodeListAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
