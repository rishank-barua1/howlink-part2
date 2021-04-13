package com.example.howlinkpart3.ui.market;

import androidx.lifecycle.ViewModel;

import com.example.howlinkpart3.R;

import java.util.ArrayList;


public class MarketViewModel extends ViewModel {
    private ArrayList<MarketObj> data1 = new ArrayList<MarketObj>();
    public ArrayList<MarketObj> getData()
    {
        data1.add(new MarketObj(R.drawable.electronic_shop,R.drawable.fruits_vegetables,"Electronics","Fruits and Vegetables"));
        data1.add(new MarketObj(R.drawable.clothing_fashion,R.drawable.foodstalls_restaurants_hotels,"Clothing and Fashion","Food stalls, restaurants and hotels"));
        data1.add(new MarketObj(R.drawable.kirana_shop,R.drawable.hardware_store,"Kirana","Hardware"));
        data1.add(new MarketObj(R.drawable.dairy_sweets_shop,R.drawable.furniture_shop,"Dairy and Sweets","Furniture"));
        data1.add(new MarketObj(R.drawable.footwear,R.drawable.jewelry_shop,"Shoes and Footwear fashion","Jewelry"));
        return data1;
    }

}