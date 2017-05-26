package com.alexfcmkh.dagger2boilerplate.data.repository;

import com.alexfcmkh.dagger2boilerplate.data.model.UserModel;
import com.alexfcmkh.dagger2boilerplate.data.retrofit.UserApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class UsersRepository implements IBaseRepository<UserModel> {

    private UserApi api;

    @Inject
    public UsersRepository(UserApi api) {
        this.api = api;
    }

    @Override
    public Observable<List<UserModel>> getAllData() {
        return api.loadUsers();
    }
}
