package com.example.myapplication.dagger.modules;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {
    String Urlpath;

    public RetrofitModule(String urlpath) {
        Urlpath = urlpath;
    }

    @Provides
    Retrofit ProvidesRetrofit()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urlpath)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
