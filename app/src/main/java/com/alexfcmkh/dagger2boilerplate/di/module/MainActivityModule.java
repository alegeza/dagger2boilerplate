package com.alexfcmkh.dagger2boilerplate.di.module;

import com.alexfcmkh.dagger2boilerplate.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
