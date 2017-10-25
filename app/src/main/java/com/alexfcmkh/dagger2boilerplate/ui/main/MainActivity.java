package com.alexfcmkh.dagger2boilerplate.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.alexfcmkh.dagger2boilerplate.R;
import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.UserListViewModel;
import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.factory.ViewModelProviderFactory;
import com.alexfcmkh.dagger2boilerplate.ui.base.RecyclerViewActivity;
import com.alexfcmkh.dagger2boilerplate.ui.model.UserItemModel;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends RecyclerViewActivity {

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

    @Override
    protected void registerRenderers(RendererRecyclerViewAdapter rendererRecyclerViewAdapter) {
//        rendererRecyclerViewAdapter.registerRenderer(new UsersViewRenderer(UserItemModel.USER_LIST_ITEM_TYPE, this));
    }

    private void setUsers(List<UserItemModel> userModels) {
//        setItems(userModels);
    }
}
