package com.example.howlinkpart3.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.howlinkpart3.R;
import com.example.howlinkpart3.ui.signinworkflow.ProfileSetup;

import java.io.File;

public class ExpandedImage extends AppCompatActivity {
    private ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_image);
        view = findViewById(R.id.expanded_image);

        Intent intent = getIntent();
        String path = intent.getStringExtra("Path to Profile Picture");
        Uri uri = Uri.parse(path);
        Glide.with(getApplicationContext()).load(uri).into(view);
    }

    protected void loadImageFromStorage(String path,ImageView iv)
    {

        try {
            File f = new File(path, "profile.jpg");
            Glide.with(getApplicationContext())
                    .load(f)// Uri of the picture
                    .into(iv);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}