package com.alexfcmkh.dagger2boilerplate.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alexfcmkh.dagger2boilerplate.MyApplication;
import com.alexfcmkh.dagger2boilerplate.R;
import com.alexfcmkh.dagger2boilerplate.mvp.presenter.UserPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((MyApplication) getApplication()).getAppComponent().inject(this);

    }
}
