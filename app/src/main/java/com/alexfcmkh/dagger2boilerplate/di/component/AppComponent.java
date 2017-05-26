package com.alexfcmkh.dagger2boilerplate.di.component;

import com.alexfcmkh.dagger2boilerplate.MyApplication;
import com.alexfcmkh.dagger2boilerplate.di.module.AppModule;
import com.alexfcmkh.dagger2boilerplate.di.module.RetrofitModule;
import com.alexfcmkh.dagger2boilerplate.ui.MainActivity;

import dagger.Component;

@Component(modules = {AppModule.class, RetrofitModule.class})
public interface AppComponent {

    void inject(MyApplication application);

    void inject(MainActivity activity);

}
