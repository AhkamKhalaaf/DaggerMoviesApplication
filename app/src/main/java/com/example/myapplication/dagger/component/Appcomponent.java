package com.example.myapplication.dagger.component;

import com.example.myapplication.MainActivity;
import com.example.myapplication.dagger.modules.Appmodule;
import com.example.myapplication.dagger.modules.RetrofitModule;

import dagger.Component;

@Component(modules = { RetrofitModule.class, Appmodule.class})
public interface Appcomponent {
    void Inject(MainActivity mainActivity);
}
