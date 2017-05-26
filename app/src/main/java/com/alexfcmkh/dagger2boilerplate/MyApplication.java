package com.alexfcmkh.dagger2boilerplate;

import android.app.Application;

import com.alexfcmkh.dagger2boilerplate.di.component.AppComponent;
import com.alexfcmkh.dagger2boilerplate.di.component.DaggerAppComponent;
import com.alexfcmkh.dagger2boilerplate.di.module.AppModule;
import com.alexfcmkh.dagger2boilerplate.di.module.RetrofitModule;

public class MyApplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();


        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule("https://jsonplaceholder.typicode.com"))
                .build();

        appComponent.inject(this);

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
