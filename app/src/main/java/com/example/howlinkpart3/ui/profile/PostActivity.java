package com.example.howlinkpart3.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.howlinkpart3.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        String path = getIntent().getStringExtra("picture");
        ImageView image = (ImageView) findViewById(R.id.post_activity_image);
        try {
            InputStream inputStream = getContentResolver().openInputStream(Uri.parse(path));
            Bitmap b = BitmapFactory.decodeStream(inputStream);
            image.setImageBitmap(b);

        } catch (FileNotFoundException e) {
            Toast.makeText(this,"Error!!!",Toast.LENGTH_SHORT).show();
        }


    }


}