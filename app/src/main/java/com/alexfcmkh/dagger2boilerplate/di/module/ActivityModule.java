package com.alexfcmkh.dagger2boilerplate.di.module;

import com.alexfcmkh.dagger2boilerplate.ui.album.AlbumListActivity;
import com.alexfcmkh.dagger2boilerplate.ui.main.MainActivity;
import com.alexfcmkh.dagger2boilerplate.ui.photo.PhotoGridActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();


    @ContributesAndroidInjector
    abstract AlbumListActivity contributeAlbumListActivity();

    @ContributesAndroidInjector
    abstract PhotoGridActivity contributePhotoGridActivity();
}
