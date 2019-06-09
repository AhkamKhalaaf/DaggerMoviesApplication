package com.example.myapplication.dagger.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class Appmodule {
    private Application application;

    public Appmodule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application provideApplication()
    {
        return application;
    }
}
