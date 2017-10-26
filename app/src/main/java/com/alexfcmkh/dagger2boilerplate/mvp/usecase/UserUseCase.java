package com.alexfcmkh.dagger2boilerplate.mvp.usecase;


import com.alexfcmkh.dagger2boilerplate.data.model.UserModel;
import com.alexfcmkh.dagger2boilerplate.data.repository.UsersRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class UserUseCase extends BaseUseCase<List<UserModel>> {

    private UsersRepository repository;

    @Inject
    public UserUseCase(UsersRepository repository) {
        this.repository = repository;
    }

    public Single<List<UserModel>> loadUsers() {
        return execute(repository.getAllData(null));
    }
}
