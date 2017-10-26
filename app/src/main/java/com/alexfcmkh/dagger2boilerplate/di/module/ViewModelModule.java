package com.alexfcmkh.dagger2boilerplate.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.alexfcmkh.dagger2boilerplate.di.ViewModelKey;
import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.AlbumsListViewModel;
import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.PhotoGridViewModel;
import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.UserListViewModel;
import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.factory.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel.class)
    abstract ViewModel bindUserListViewModel(UserListViewModel userListViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(AlbumsListViewModel.class)
    abstract ViewModel bindAlbumsListViewModel(AlbumsListViewModel albumsListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PhotoGridViewModel.class)
    abstract ViewModel bindPhotoGridViewModel(PhotoGridViewModel photoGridViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory factory);
}

