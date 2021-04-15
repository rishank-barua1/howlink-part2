package com.example.howlinkpart3.ui.signinworkflow.profileSetup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.howlinkpart3.MainActivity;
import com.example.howlinkpart3.R;
import com.example.howlinkpart3.ui.profile.ProfileViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ProfileSetup extends AppCompatActivity {
    public static final String PROFILE_PIC = "Path to profile picture";
    private ImageButton profileButton;
    private TextInputEditText BIO,PINCODE;
    private Button nextButton,saveButton;
    private AppCompatTextView tehsil, district, state;
    private ProfileSetupViewModel mProfileViewModel;
    public static final String PROFILE_TAG = "Profile Set";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_setup_activity);

        tehsil= findViewById(R.id.tehsil);
        state = findViewById(R.id.state);
        district = findViewById(R.id.district);
        profileButton = findViewById(R.id.profile_image_setter);
        BIO = findViewById(R.id.bio_edit);
        PINCODE = findViewById(R.id.pincode_edit);
        nextButton = findViewById(R.id.next_button);
        saveButton = findViewById(R.id.save_details);

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
        if(preferences.getBoolean("isProfilePictureSelected",false))
            Glide.with(getApplicationContext()).load(preferences.getString(PROFILE_PIC,"")).transform(new CircleCrop()).into(profileButton);
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
                    mProfileViewModel = new ViewModelProvider(getViewModelStore(), new MyViewModelProvider(getApplication(),pincode)).get(ProfileSetupViewModel.class);
                    ArrayList<String> data = new ArrayList<>();
                    data = mProfileViewModel.getData();
                    tehsil.setText(data.get(0)); district.setText(data.get(1)); state.setText(data.get(2));
                    nextButton.setVisibility(View.GONE);
                    saveButton.setVisibility(View.VISIBLE);
                    saveButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(ProfileSetup.this,MainActivity.class));
                        }
                    });
                }
            }
        });
    }

    public void openCamera(View view) {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);


       /* final CharSequence[]  choices= {"Use a camera","From Gallery"};
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
        alert.show();*/


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                SharedPreferences preferences = getSharedPreferences(PROFILE_TAG,MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(PROFILE_PIC,String.valueOf(resultUri));
                editor.putBoolean("isProfilePictureSelected",true);
                editor.commit();
                Glide.with(getApplicationContext()).load(resultUri).transform(new CircleCrop()).into(profileButton);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    protected String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    protected void loadImageFromStorage(String path,ImageView iv)
    {

        try {
            File f = new File(path, "profile.jpg");
            Glide.with(getApplicationContext())
                    .load(f)
                    .transform(new CircleCrop())// Uri of the picture
                    .into(profileButton);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}


