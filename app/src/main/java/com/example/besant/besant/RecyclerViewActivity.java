package com.example.besant.besant;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends Activity {
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    LinearLayoutManager layoutManager;
    String[] items;
    int[] img_res = {R.drawable.auto, R.drawable.bus, R.drawable.car, R.drawable.cycle};
    ArrayList<Dataprovider> arrayList = new ArrayList<Dataprovider>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.Recycler_view);
        items = getResources().getStringArray(R.array.items);
        int i = 0;
        for (String name : items) {
            Dataprovider dataprovider = new Dataprovider(img_res[i], name, items[i]);
            arrayList.add(dataprovider);
            i++;
        }
        adapter = new RecyclerViewAdapter(RecyclerViewActivity.this, arrayList);
        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(RecyclerViewActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDividerItemDecoration);
    }
}
