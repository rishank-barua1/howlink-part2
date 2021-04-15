package com.example.howlinkpart3.ui.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.howlinkpart3.R;
import com.example.howlinkpart3.databinding.ActivityPostBinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PostActivity extends AppCompatActivity {
    private AppCompatButton nextButton;
    private ActivityPostBinding binding;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.postActivityImage.setImageURI(getIntent().getData());
        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(PostActivity.this,CaptionWriting.class);
                startActivity(intent);
            }
        });
    }


}