package com.alexfcmkh.dagger2boilerplate.data.retrofit;

import com.alexfcmkh.dagger2boilerplate.data.model.UserModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface UserApi {
    @GET("/users")
    Single<List<UserModel>> loadUsers();
}
