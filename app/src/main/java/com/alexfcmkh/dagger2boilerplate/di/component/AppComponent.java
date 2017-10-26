package com.alexfcmkh.dagger2boilerplate.di.component;

import android.content.Context;

import com.alexfcmkh.dagger2boilerplate.MyApplication;
import com.alexfcmkh.dagger2boilerplate.di.module.ActivityModule;
import com.alexfcmkh.dagger2boilerplate.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ActivityModule.class})
public interface AppComponent {

    void inject(MyApplication application);


    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        AppComponent build();
    }

}
