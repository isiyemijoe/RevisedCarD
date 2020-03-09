package com.example.revisedcard;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    CardView view;
    List<Sport> mSportData;
    RecyclerView recyclerView;
    SportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSportData = new ArrayList<>();
        initializeData();
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new SportAdapter(this, mSportData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    public void initializeData() {

        TypedArray sportImageResources = getResources().obtainTypedArray(R.array.sport_image);
        String[] sportTitle = getResources().getStringArray(R.array.sports_titles);
        String[] sportInfo = getResources().getStringArray(R.array.sports_info);

        mSportData.clear();
        for (int i = 0; i < sportTitle.length; i++) {
            mSportData.add(new Sport(sportTitle[i], sportInfo[i],
                    sportImageResources.getResourceId(i, 0)));
        }
        sportImageResources.recycle();
    }
}
