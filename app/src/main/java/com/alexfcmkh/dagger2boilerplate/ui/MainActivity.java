package com.alexfcmkh.dagger2boilerplate.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.alexfcmkh.dagger2boilerplate.R;
import com.alexfcmkh.dagger2boilerplate.data.model.UserModel;
import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.UserListViewModel;
import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.factory.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import timber.log.Timber;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    UserListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(UserListViewModel.class);

        viewModel.getUsers().observe(this, this::setUsers);

        viewModel.loadUsers();
    }


    private void setUsers(List<UserModel> userModels) {
        Timber.log(1, "Count of users " + userModels.size());
    }
}
