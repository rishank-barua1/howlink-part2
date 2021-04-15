package com.example.howlinkpart3.ui.profile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.howlinkpart3.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

public class EditProfile extends AppCompatActivity {
    private AppCompatButton create_shop,personal_info;
    private TextView change_background,change_profile;
    private AppCompatImageButton save,discard;
    private ImageView background, profile;
    private TextInputEditText Bio,Name;
    private String filepath= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Intent intent = getIntent();
        profile = findViewById(R.id.imageView1);
        Bio = findViewById(R.id.bio_edit1);
        Name = findViewById(R.id.username_edit1);
        save = findViewById(R.id.edit_save);
        discard = findViewById(R.id.edit_save);
        create_shop = findViewById(R.id.create_shop);
        change_background = findViewById(R.id.change_background_picture);
        personal_info = findViewById(R.id.personal_info);
        change_profile = findViewById(R.id.change_profile_picture);
        String path = intent.getStringExtra("Path to Profile Picture");
        Glide.with(this).load(Uri.parse(path)).into(profile);
        String bio = intent.getStringExtra("Bio");
        String name = intent.getStringExtra("Name");
        Bio.setText(bio); Name.setText(name);

        personal_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditProfile.this,PersonalSetting.class));
            }
        });
        change_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[]  choices= {"From Gallery"};
                AlertDialog.Builder alt_bld = new AlertDialog.Builder(EditProfile.this);
                //alt_bld.setIcon(R.drawable.icon);
                alt_bld.setTitle("Select a picture");
                alt_bld.setSingleChoiceItems(choices, -1, new DialogInterface
                        .OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(i,102);

                        dialog.dismiss();
                    }
                });
                AlertDialog alert = alt_bld.create();
                alert.show();
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Name.getText().toString();
                String bio = Bio.getText().toString();
                Intent replyIntent = new Intent();
                replyIntent.putExtra("Name",username);
                replyIntent.putExtra("Bio",bio);
                replyIntent.putExtra("Path to Profile Picture",filepath);
                setResult(RESULT_OK,replyIntent);
                finish();


            }
        });

        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent=new Intent();
                setResult(RESULT_CANCELED,replyIntent);
                finish();
            }
        });


        create_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[]  choices= {"Channel","Market","Entity"};
                AlertDialog.Builder alt_bld = new AlertDialog.Builder(EditProfile.this);
                //alt_bld.setIcon(R.drawable.icon);
                alt_bld.setTitle(null);
                alt_bld.setSingleChoiceItems(choices, -1, new DialogInterface
                        .OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(getApplicationContext(),
                                "Group Name = "+choices[item], Toast.LENGTH_SHORT).show();
                        dialog.dismiss();// dismiss the alertbox after chose option

                    }
                });
                AlertDialog alert = alt_bld.create();
                alert.show();


            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 102) {
            Uri filepath1 = data.getData();
            filepath = String.valueOf(filepath1);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filepath1);
                profile.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}