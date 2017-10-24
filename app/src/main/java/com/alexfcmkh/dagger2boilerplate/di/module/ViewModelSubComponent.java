package com.alexfcmkh.dagger2boilerplate.di.module;

import com.alexfcmkh.dagger2boilerplate.mvp.viewmodel.UserListViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    UserListViewModel userListViewModel();
}
