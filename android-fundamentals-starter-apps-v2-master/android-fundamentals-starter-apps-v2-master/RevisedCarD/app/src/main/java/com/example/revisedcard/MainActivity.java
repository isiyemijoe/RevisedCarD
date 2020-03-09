package com.example.revisedcard;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static androidx.recyclerview.widget.ItemTouchHelper.*;
import static androidx.recyclerview.widget.ItemTouchHelper.RIGHT;


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

        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, LEFT | RIGHT) {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                return 0;
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
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
