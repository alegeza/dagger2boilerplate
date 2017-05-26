package com.alexfcmkh.dagger2boilerplate.di.module;

import com.alexfcmkh.dagger2boilerplate.mvp.presenter.UserPresenter;
import com.alexfcmkh.dagger2boilerplate.mvp.usecase.UserUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    UserPresenter provideUserPresenter(UserUseCase usecase) {
        return new UserPresenter(usecase);
    }
}
