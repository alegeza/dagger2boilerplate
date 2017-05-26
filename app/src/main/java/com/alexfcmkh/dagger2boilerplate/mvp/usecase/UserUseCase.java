package com.alexfcmkh.dagger2boilerplate.mvp.usecase;


import com.alexfcmkh.dagger2boilerplate.data.repository.UsersRepository;

import javax.inject.Inject;

public class UserUseCase extends BaseUseCase {

    private UsersRepository repository;

    @Inject
    public UserUseCase(UsersRepository repository) {
        this.repository = repository;
    }
}
