package com.example.howlinkpart3.ui.market;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class MarketObj {
    int imageID_left, imageID_right;
    String textView_left,textView_right;

    public MarketObj(int path_left,int path_right,String textView_left, String textView_right)
    {

        this.imageID_left= path_left;
        this.textView_left = textView_left;
        this.textView_right =textView_right;
        this.imageID_right = path_right;
    }

    public String getTextView_right() {
        return textView_right;
    }

    public String getTextView_left() {
        return textView_left;
    }

    public int getImageID_left() {
        return imageID_left;
    }

    public int getImageID_right() {
        return imageID_right;
    }
}
