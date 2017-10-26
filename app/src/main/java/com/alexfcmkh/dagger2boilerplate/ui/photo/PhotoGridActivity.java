package com.alexfcmkh.dagger2boilerplate.ui.photo;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.PhotoGridViewModel;
import com.alexfcmkh.dagger2boilerplate.ui.base.RecyclerViewActivity;
import com.alexfcmkh.dagger2boilerplate.ui.model.PhotoItemModel;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;

import java.util.List;


public class PhotoGridActivity extends RecyclerViewActivity {

    private static final String EXTRA_ALBUM_ID = "com.alexfcmkh.dagger2boilerplate.extra.ALBUM_ID";

    PhotoGridViewModel viewModel;

    public static Intent createStartIntent(Context context, int albumId) {
        Intent intent = new Intent(context, PhotoGridActivity.class);
        intent.putExtra(EXTRA_ALBUM_ID, albumId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(PhotoGridViewModel.class);
        viewModel.getPhotosLiveData().observe(this, this::setPhotos);
        viewModel.loadPhotos(getIntent().getIntExtra(EXTRA_ALBUM_ID, 0));
    }

    private void setPhotos(List<PhotoItemModel> photoItemModels) {
        setItems(photoItemModels);
    }

    @Override
    protected void createItemDecorator(RecyclerView recyclerView) {
        recyclerView.removeItemDecoration(recyclerView.getItemDecorationAt(0));
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        return new GridLayoutManager(this, 5);
    }

    @Override
    protected void registerRenderers(RendererRecyclerViewAdapter rendererRecyclerViewAdapter) {
        PhotoViewRenderer renderer = new PhotoViewRenderer(PhotoItemModel.PHOTO_LIST_ITEM_TYPE, this);
        rendererRecyclerViewAdapter.registerRenderer(renderer);
    }

    @Override
    public void onRefresh() {
        viewModel.loadPhotos(getIntent().getIntExtra(EXTRA_ALBUM_ID, 0));
    }
}
