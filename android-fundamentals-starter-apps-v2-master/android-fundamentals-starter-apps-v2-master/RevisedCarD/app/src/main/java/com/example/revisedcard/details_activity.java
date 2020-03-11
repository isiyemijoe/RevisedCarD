package com.example.revisedcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class details_activity extends AppCompatActivity {
    TextView title_textview;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_activity);

        title_textview = findViewById(R.id.sport_detail_title_text);
        imageView = findViewById(R.id.sport_detail_image);

        title_textview.setText(getIntent().getStringExtra("title"));
        Glide.with(this)
                .load(getIntent().getIntExtra("image_Resource", 0))
                .into(imageView);
    }
}
