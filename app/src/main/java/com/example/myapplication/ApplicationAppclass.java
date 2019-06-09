package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.dagger.component.Appcomponent;
import com.example.myapplication.dagger.component.DaggerAppcomponent;
import com.example.myapplication.dagger.modules.Appmodule;
import com.example.myapplication.dagger.modules.RetrofitModule;

public class ApplicationAppclass extends Application {
     Appcomponent appcomponent;
    @Override
    public void onCreate() {
        super.onCreate();
       appcomponent = DaggerAppcomponent.builder().
               retrofitModule(new RetrofitModule("http://api.themoviedb.org/3/search/")).appmodule(new Appmodule(this))
               .build();

    }
}
