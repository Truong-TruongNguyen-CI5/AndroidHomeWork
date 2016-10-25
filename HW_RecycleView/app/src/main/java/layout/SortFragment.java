package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyen.hw_recycleview.FoodPlaceAdapter;
import com.example.nguyen.hw_recycleview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SortFragment extends Fragment {
    private FoodPlaceAdapter foodPlaceAdapter;
    @BindView(R.id.rv_sort)
    RecyclerView rvSort;

    public SortFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sort, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        rvSort.setLayoutManager(layoutManager);
        foodPlaceAdapter = new FoodPlaceAdapter();
        foodPlaceAdapter.notifyDataSetChanged();
        rvSort.setAdapter(foodPlaceAdapter);
        rvSort.setPadding(20,20,20,20);
    }

}
