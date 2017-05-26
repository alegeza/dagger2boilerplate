package com.alexfcmkh.dagger2boilerplate.mvp.presenter;

import com.alexfcmkh.dagger2boilerplate.mvp.usecase.UserUseCase;

import javax.inject.Inject;

public class UserPresenter {

    private UserUseCase useCase;

    @Inject
    public UserPresenter(UserUseCase useCase) {
        this.useCase = useCase;
    }
}
