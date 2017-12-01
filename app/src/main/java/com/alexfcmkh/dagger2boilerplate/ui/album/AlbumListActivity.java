package com.alexfcmkh.dagger2boilerplate.ui.album;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.AlbumsListViewModel;
import com.alexfcmkh.dagger2boilerplate.ui.base.RecyclerViewActivity;
import com.alexfcmkh.dagger2boilerplate.ui.model.AlbumItemModel;
import com.f2prateek.dart.InjectExtra;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;


public class AlbumListActivity extends RecyclerViewActivity {

    private static final String EXTRA_USER_ID = "com.alexfcmkh.dagger2boilerplate.extra.USER_ID";
    @InjectExtra(EXTRA_USER_ID)
    int userId;
    private AlbumsListViewModel albumsListViewModel;

    public static Intent createStartIntent(Context context, int userId) {
        Intent intent = new Intent(context, AlbumListActivity.class);
        intent.putExtra(EXTRA_USER_ID, userId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        albumsListViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(AlbumsListViewModel.class);
        albumsListViewModel.setUserId(userId);
        albumsListViewModel.getAlbums().observe(this, this::setItems);
        albumsListViewModel.getLoadingProgressLiveData().observe(this, this::toggleProgressView);
        albumsListViewModel.loadAlbums();
    }

    @Override
    protected void registerRenderers(RendererRecyclerViewAdapter rendererRecyclerViewAdapter) {
        AlbumsViewRenderer renderer = new AlbumsViewRenderer(AlbumItemModel.ALBUM_LIST_ITEM_TYPE, this, model -> navigateToPhotos(model.getAlbumId()));
        rendererRecyclerViewAdapter.registerRenderer(renderer);
    }

    private void navigateToPhotos(int albumId) {
        navigationController.navigateToPhotos(albumId);
    }

    @Override
    public void onRefresh() {
        albumsListViewModel.loadAlbums();
    }
}
