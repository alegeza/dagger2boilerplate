package com.alexfcmkh.dagger2boilerplate.di.module;

import android.content.Context;

import com.alexfcmkh.dagger2boilerplate.MyApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private MyApplication app;

    public AppModule(MyApplication app) {
        this.app = app;
    }

    @Provides
    Context provideContext() {
        return this.app;
    }
}
