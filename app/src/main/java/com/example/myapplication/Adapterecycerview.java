package com.example.myapplication;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.ItemlayoutBinding;
import com.example.myapplication.utils.Apiresponse;

import java.util.ArrayList;
import java.util.List;

public class Adapterecycerview extends RecyclerView.Adapter<Adapterecycerview.MyViewholder> {
    Context context;
    List<Apiresponse.OneMovie>arrayList;

    public Adapterecycerview(Context context, List<Apiresponse.OneMovie> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemlayoutBinding itemlayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.itemlayout,viewGroup,false);
        return new MyViewholder(itemlayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder myViewholder, int i) {
        Apiresponse.OneMovie oneMovie = arrayList.get(i);
        myViewholder.itemlayoutBinding.setMoviedata(oneMovie);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        ItemlayoutBinding itemlayoutBinding;
        public MyViewholder(@NonNull ItemlayoutBinding itemlayoutBinding) {
            super(itemlayoutBinding.getRoot());
            this.itemlayoutBinding = itemlayoutBinding;
        }
    }
}
