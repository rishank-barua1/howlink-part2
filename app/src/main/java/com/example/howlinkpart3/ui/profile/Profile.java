package com.example.howlinkpart3.ui.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.howlinkpart3.R;
import com.example.howlinkpart3.ui.signinworkflow.ProfileSetup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Profile extends Fragment {

    private ProfileViewModel mViewModel;
    private ImageButton backgroundPicture;
    private ShapeableImageView profilePicture;
    private TextView Name,Bio;
    public static final String POST_PIC = "URI FOR POST_IMAGE";
    private FloatingActionButton editProfile;
    private ImageView expandedImage;
    private AppCompatButton postButton;
    public static Profile newInstance() {
        return new Profile();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        Bio = view.findViewById(R.id.profile_bio);
        Name = view.findViewById(R.id.profile_name);
        profilePicture = view.findViewById(R.id.profile_picture);
        backgroundPicture = view.findViewById(R.id.background_image);
        editProfile = view.findViewById(R.id.floatingActionButton2);
        postButton = view.findViewById(R.id.post_button);
        SharedPreferences preferences = getActivity().getSharedPreferences(ProfileSetup.PROFILE_TAG,Context.MODE_PRIVATE);
        String bio = preferences.getString("Bio",null);
        if(bio!=null)
        {
            Bio.setText(bio);
        }
        if(preferences.getBoolean("isProfilePictureSelected",false))
        {
            Uri imageUri = Uri.parse(preferences.getString(ProfileSetup.PROFILE_PIC,""));
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
                profilePicture.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(Intent.createChooser(i,"Browse for image"),45);
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bio = Bio.getText().toString();
                String name = Name.getText().toString();
                Intent i = new Intent(getActivity(),EditProfile.class);
                i.putExtra("Name",name);
                i.putExtra("Path to Profile Picture",preferences.getString(ProfileSetup.PROFILE_PIC,""));
                i.putExtra("Bio",bio);
                startActivityForResult(i,122);
            }
        });

        profilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),ExpandedImage.class);
                i.putExtra("Path to Profile Picture",preferences.getString(ProfileSetup.PROFILE_PIC,""));
                startActivity(i);
            }
        });

        backgroundPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),ExpandedImage.class);
              //  i.putExtra("Path to Profile Picture",path);
                startActivity(i);
            }
        });



        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode== Activity.RESULT_OK && requestCode==122)
        {
            Bio.setText(data.getStringExtra("Bio"));
            Name.setText(data.getStringExtra("Name"));


        }

        if(resultCode == Activity.RESULT_OK && requestCode==45)
        {
            Uri filepath = data.getData();
            Intent dsPhotoEditorIntent = new Intent(getContext(), DsPhotoEditorActivity.class);
            dsPhotoEditorIntent.setData(filepath);
            dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "PostsHowlink");
            int[] toolsToHide = {DsPhotoEditorActivity.TOOL_ORIENTATION};
            dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);
            startActivityForResult(dsPhotoEditorIntent, 200);

        }
        if (resultCode == Activity.RESULT_OK && requestCode==200) {
            Intent intent = new Intent(getContext(),PostActivity.class);
            intent.setData(data.getData());
            startActivity(intent);


        }
        super.onActivityResult(requestCode, resultCode, data);
    }




    protected String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getContext());
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
            File f=new File(path, "profile.jpg");
            Glide.with(getContext())
                    .load(f)
                    .transform(new CircleCrop())// Uri of the picture
                    .into(profilePicture);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    public Bitmap getCroppedBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
                bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        //Bitmap _bmp = Bitmap.createScaledBitmap(output, 60, 60, false);
        //return _bmp;
        return output;
    }
}