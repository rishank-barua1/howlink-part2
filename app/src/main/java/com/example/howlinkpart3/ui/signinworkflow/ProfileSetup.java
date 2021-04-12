package com.example.howlinkpart3.ui.signinworkflow;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.animation.Animator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.howlinkpart3.MainActivity;
import com.example.howlinkpart3.R;
import com.example.howlinkpart3.ui.profile.Profile;
import com.google.android.material.textfield.TextInputEditText;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;

public class ProfileSetup extends AppCompatActivity {
    private ImageButton profileButton;
    private TextInputEditText BIO,PINCODE;
    private Button nextButton;
    public static final String PROFILE_TAG = "Profile Set";
    private Animator currentAnimator;
    private int shortAnimationDuration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_setup_activity);
        profileButton = findViewById(R.id.profile_image_setter);
        BIO = findViewById(R.id.bio_edit);
        PINCODE = findViewById(R.id.pincode_edit);
        nextButton = findViewById(R.id.next_button);
        SharedPreferences preferences =getSharedPreferences(PROFILE_TAG,MODE_PRIVATE);
        String bio = preferences.getString("Bio",null);
        String pincode = preferences.getString("Pincode",null);
        if(bio!=null)
        {
            BIO.setText(bio);
        }
        if(pincode!=null)
        {
            PINCODE.setText(pincode);
        }
        String imagePath = preferences.getString("Path to picture","");
        if(imagePath.equalsIgnoreCase(""))
        {
            Glide.with(this).load(imagePath).into(profileButton);
        }
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bio = BIO.getText().toString();
                String pincode = PINCODE.getText().toString();
                if(pincode.length()!=6)
                {
                    PINCODE.setError("A pincode of length 6 is mandatory");
                }
                else
                {
                    SharedPreferences preferences = getSharedPreferences(PROFILE_TAG,MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Bio",bio);
                    editor.putString("Pincode",pincode);
                    editor.apply();
                    editor.commit();
                    startActivity(new Intent(ProfileSetup.this, MainActivity.class));

                }
            }
        });
    }

    public void openCamera(View view) {
        final CharSequence[]  choices= {"Use a camera","From Gallery"};
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(ProfileSetup.this);
        //alt_bld.setIcon(R.drawable.icon);
        alt_bld.setTitle("Select a picture");
        alt_bld.setSingleChoiceItems(choices, -1, new DialogInterface
                .OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                switch (item)
                {
                    case 0:
                        Dexter.withContext(ProfileSetup.this)
                                .withPermission(Manifest.permission.CAMERA)
                                .withListener(new PermissionListener() {
                                    @Override
                                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                        startActivityForResult(i,102);
                                    }

                                    @Override
                                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                                    }

                                    @Override
                                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                                    }
                                }).check();
                        break;
                    case 1:
                        Dexter.withContext(ProfileSetup.this)
                                .withPermission(Manifest.permission.CAMERA)
                                .withListener(new PermissionListener() {
                                    @Override
                                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                        Intent i = new Intent(Intent.ACTION_PICK);
                                        i.setType("image/*");
                                        startActivityForResult(Intent.createChooser(i,"Browse for image"),103);
                                    }

                                    @Override
                                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                                    }

                                    @Override
                                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                                    }
                                }).check();
                        break;
                }
                dialog.dismiss();


            }
        });
        AlertDialog alert = alt_bld.create();
        alert.show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == 102)
        {
            Bitmap realImage = (Bitmap)data.getExtras().get("data");
            profileButton.setImageBitmap(realImage);



        }

        if(requestCode == 103 && resultCode == RESULT_OK)
        {
            Uri filepath = data.getData();
            String path = Profile.getPathFromUri(ProfileSetup.this,filepath);
            try
            {
                Glide.with(ProfileSetup.this).load(path).into(profileButton);
                SharedPreferences preferences = getSharedPreferences(PROFILE_TAG,MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Path to picture",path);
                editor.apply();editor.commit();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}


