package com.alexfcmkh.dagger2boilerplate.ui.base;

import android.os.Bundle;

import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.factory.ViewModelProviderFactory;
import com.alexfcmkh.dagger2boilerplate.ui.navigation.NavigationController;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Inject
    protected ViewModelProviderFactory viewModelProviderFactory;

    @Inject
    protected NavigationController navigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
