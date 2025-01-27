package com.example.task1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> dataset;
    private ArrayList<DataModel> filteredDataset;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CustomeAdapter adapter;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleViewResult);
        searchBar = findViewById(R.id.searchBar);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dataset = new ArrayList<DataModel>();
        filteredDataset = new ArrayList<>();

        for(int i = 0; i < MyData.nameArray.length; i++){
            dataset.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.descriptionArray[i],
                    MyData.imageArray[i],
                    MyData.id[i]
            ));
        }

        filteredDataset.addAll(dataset);
        adapter = new CustomeAdapter(filteredDataset);
        recyclerView.setAdapter(adapter);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterList(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void filterList(String query) {
        filteredDataset.clear();
        if (query.isEmpty()) {
            filteredDataset.addAll(dataset);
        } else {
            for (DataModel item : dataset) {
                if (item.getName().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT))) {
                    filteredDataset.add(item);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}