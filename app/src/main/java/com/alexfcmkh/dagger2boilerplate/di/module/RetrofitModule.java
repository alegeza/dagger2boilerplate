package com.alexfcmkh.dagger2boilerplate.di.module;

import android.support.annotation.NonNull;

import com.alexfcmkh.dagger2boilerplate.data.retrofit.UserApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RetrofitModule {

    private Retrofit retrofit;

    public RetrofitModule(@NonNull String baseApi) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseApi)
                .build();
    }

    @Provides
    Retrofit provideRetrofit() {
        return this.retrofit;
    }

    @Provides
    UserApi provideUserApi(Retrofit retrofit) {
        return retrofit.create(UserApi.class);
    }
}
