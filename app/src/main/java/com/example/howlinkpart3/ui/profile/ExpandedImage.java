package com.example.howlinkpart3.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.howlinkpart3.R;

public class ExpandedImage extends AppCompatActivity {
    private ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_image);
        view = findViewById(R.id.expanded_image);

        Intent intent = getIntent();
        String path = intent.getStringExtra("Path to Profile Picture");
        Glide.with(ExpandedImage.this).load(path).into(view);
    }
}