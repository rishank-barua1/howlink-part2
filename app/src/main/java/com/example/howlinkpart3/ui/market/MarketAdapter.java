package com.example.howlinkpart3.ui.market;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.howlinkpart3.R;

import java.util.ArrayList;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketViewHolder> {

    private LayoutInflater mLayoutInflater;
    private ArrayList<MarketObj> local_data = new ArrayList<>();

    @NonNull
    @Override
    public MarketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mLayoutInflater.inflate(R.layout.market_viewholder,parent,false);
        MarketViewHolder holder = new MarketViewHolder(mItemView, new onItemClickListener() {
            @Override
            public void onCick_left(int id) {

            }

            @Override
            public void onClick_right(int id) {

            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull MarketViewHolder holder, int position) {
        MarketObj current = local_data.get(position);
        holder.text_left.setText(current.getTextView_left());
        holder.text_right.setText(current.getTextView_right());
        holder.imageButton_right.setImageResource(current.getImageID_right());
        holder.imageButton_left.setImageResource(current.getImageID_left());
    }

    @Override
    public int getItemCount() {
        return local_data.size();
    }
    public MarketAdapter(Context context, ArrayList<MarketObj>data)
    {
        this.local_data = data;
        this.mLayoutInflater = LayoutInflater.from(context);

    }
    class MarketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        onItemClickListener listener;
        TextView text_left,text_right ;
        ImageButton imageButton_left,imageButton_right;
        public MarketViewHolder(@NonNull View itemView, onItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            text_left = itemView.findViewById(R.id.text_left);
            text_right = itemView.findViewById(R.id.text_right);
            imageButton_left = itemView.findViewById(R.id.image_left);
            imageButton_right = itemView.findViewById(R.id.image_right);
            imageButton_left.setOnClickListener(this);
            imageButton_right.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.image_left:
                    listener.onCick_left(this.getLayoutPosition());
                    break;
                case R.id.image_right:
                    listener.onClick_right(this.getLayoutPosition());
                    break;
            }
        }
    }
}

interface onItemClickListener
{

    void onCick_left(int id);
    void onClick_right(int id);
}
