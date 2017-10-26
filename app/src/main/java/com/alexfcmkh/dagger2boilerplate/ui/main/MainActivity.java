package com.alexfcmkh.dagger2boilerplate.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.UserListViewModel;
import com.alexfcmkh.dagger2boilerplate.ui.base.RecyclerViewActivity;
import com.alexfcmkh.dagger2boilerplate.ui.model.UserItemModel;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;

import java.util.List;

public class MainActivity extends RecyclerViewActivity {

    UserListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(UserListViewModel.class);
        viewModel.getUsers().observe(this, this::setUsers);

        viewModel.getLoadingProgressLiveData().observe(this, this::toggleProgressView);
        viewModel.getInfoMessageLiveData().observe(this, this::showMessage);

        viewModel.loadUsers();
    }

    @Override
    protected void registerRenderers(RendererRecyclerViewAdapter rendererRecyclerViewAdapter) {
        UsersViewRenderer usersViewRenderer = new UsersViewRenderer(UserItemModel.USER_LIST_ITEM_TYPE, this, this::navigateToAlbums);
        rendererRecyclerViewAdapter.registerRenderer(usersViewRenderer);
    }

    private void navigateToAlbums(UserItemModel model) {
        navigationController.navigateToAlbums(model.getUserId());
    }

    private void setUsers(List<UserItemModel> userModels) {
        setItems(userModels);
    }

    @Override
    public void onRefresh() {
        viewModel.loadUsers();
    }
}
