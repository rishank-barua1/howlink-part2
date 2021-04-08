package com.example.howlinkpart3.ui.signinworkflow;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.howlinkpart3.R;
import com.example.howlinkpart3.ui.profile.Profile;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;

public class ProfileSetup extends AppCompatActivity {
    private ImageButton profileButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_setup_activity);
        profileButton = findViewById(R.id.profile_image_setter);
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
            Bitmap bitmap= (Bitmap)data.getExtras().get("data");
            profileButton.setImageBitmap(bitmap);

        }

        if(requestCode == 103 && resultCode == RESULT_OK)
        {
            Uri filepath = data.getData();
            try
            {
                InputStream inputStream = getContentResolver().openInputStream(filepath);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                profileButton.setImageBitmap(bitmap);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}