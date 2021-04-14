package com.example.howlinkpart3.ui.market;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.howlinkpart3.R;

import java.util.ArrayList;

public class Market extends Fragment {

    private MarketViewModel mViewModel;
    private RecyclerView mRecycler;
    private MarketAdapter mAdapter;
    private ArrayList<MarketObj> data1 ;
    public static Market newInstance() {
        return new Market();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_market, container, false);
        mRecycler = view.findViewById(R.id.recyler1);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MarketViewModel.class);
        data1 = new ArrayList<>();
        data1 = mViewModel.getData();
        mAdapter = new MarketAdapter(getContext(),data1);
        mRecycler.setAdapter(mAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        // TODO: Use the ViewModel
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
}