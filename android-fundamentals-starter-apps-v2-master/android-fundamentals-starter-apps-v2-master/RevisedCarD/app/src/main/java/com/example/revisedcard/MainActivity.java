package com.example.revisedcard;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static androidx.recyclerview.widget.ItemTouchHelper.*;
import static androidx.recyclerview.widget.ItemTouchHelper.RIGHT;


public class MainActivity extends AppCompatActivity {
    CardView view;
    List<Sport> mSportData;
    RecyclerView recyclerView;
    SportAdapter adapter;
    FloatingActionButton refreshFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSportData = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new SportAdapter(this, mSportData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        initializeData();

        ItemTouchHelper helper = new ItemTouchHelper(new SimpleCallback(LEFT | RIGHT | UP | DOWN, LEFT | RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(mSportData, from, to);
                adapter.notifyItemMoved(from, to);
                toast();
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                mSportData.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(recyclerView);


    }

    private void toast() {
        Toast.makeText(this, "Item has been Moved", Toast.LENGTH_SHORT).show();
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
