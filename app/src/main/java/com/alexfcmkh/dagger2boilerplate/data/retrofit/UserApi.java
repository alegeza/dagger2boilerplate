package com.alexfcmkh.dagger2boilerplate.data.retrofit;

import com.alexfcmkh.dagger2boilerplate.data.model.UserModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserApi {
    @GET
    Observable<List<UserModel>> loadUsers();
}
