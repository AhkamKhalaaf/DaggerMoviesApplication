package com.example.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.utils.Apiresponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;
    Adapterecycerview adapterecycerview;
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.recycerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        activityMainBinding.recycerview.hasFixedSize();
        getData();
        activityMainBinding.refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
                activityMainBinding.refresh.setRefreshing(false);
            }
        });


    }


    public void getData()
    {
        ((ApplicationAppclass)getApplication()).appcomponent.Inject(MainActivity.this);
        Call<Apiresponse> call = retrofit.create(Apiinterfaceretrofit.class).getData("b3070a5d3abfb7c241d2688d066914e7",
                "Little",1);
        call.enqueue(new Callback<Apiresponse>() {
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                if (response.isSuccessful())
                {
                    adapterecycerview = new Adapterecycerview(MainActivity.this,response.body().getResults());
                    activityMainBinding.recycerview.setAdapter(adapterecycerview);
                    //Toast.makeText(MainActivity.this,response.body().getResults().size()+"",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Apiresponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage()+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
