package com.alexfcmkh.dagger2boilerplate.ui.navigation;

import android.content.Context;
import android.content.Intent;

import com.alexfcmkh.dagger2boilerplate.ui.album.AlbumListActivity;
import com.alexfcmkh.dagger2boilerplate.ui.photo.PhotoGridActivity;

import javax.inject.Inject;

public class NavigationController {

    private Context context;

    @Inject
    public NavigationController(Context context) {
        this.context = context;
    }

    public void navigateToAlbums(int userId) {
        Intent intent = AlbumListActivity.createStartIntent(context, userId);
        context.startActivity(intent);
    }

    public void navigateToPhotos(int albumId) {
        Intent intent = PhotoGridActivity.createStartIntent(context, albumId);
        context.startActivity(intent);
    }
}
