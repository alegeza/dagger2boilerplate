package com.alexfcmkh.dagger2boilerplate.di.module;

import com.alexfcmkh.dagger2boilerplate.BuildConfig;
import com.alexfcmkh.dagger2boilerplate.data.retrofit.AlbumApi;
import com.alexfcmkh.dagger2boilerplate.data.retrofit.PhotoApi;
import com.alexfcmkh.dagger2boilerplate.data.retrofit.UserApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.support.AndroidSupportInjectionModule;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {ViewModelModule.class, AndroidSupportInjectionModule.class})
public class AppModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(interceptor);
        }

        OkHttpClient client = httpClientBuilder.build();

        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    UserApi provideUserApi(Retrofit retrofit) {
        return retrofit.create(UserApi.class);
    }


    @Provides
    @Singleton
    AlbumApi provideAlbumApi(Retrofit retrofit) {
        return retrofit.create(AlbumApi.class);
    }

    @Provides
    @Singleton
    PhotoApi providePhotoApi(Retrofit retrofit) {
        return retrofit.create(PhotoApi.class);
    }
}
