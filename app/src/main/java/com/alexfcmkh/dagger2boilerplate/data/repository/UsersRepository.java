package com.alexfcmkh.dagger2boilerplate.data.repository;

import android.support.annotation.Nullable;

import com.alexfcmkh.dagger2boilerplate.data.model.UserModel;
import com.alexfcmkh.dagger2boilerplate.data.repository.query.request.Query;
import com.alexfcmkh.dagger2boilerplate.data.retrofit.UserApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class UsersRepository implements IBaseRepository<UserModel> {

    private UserApi api;

    @Inject
    public UsersRepository(UserApi api) {
        this.api = api;
    }

    @Override
    public Single<List<UserModel>> getAllData(@Nullable Query query) {
        return api.loadUsers();
    }
}
