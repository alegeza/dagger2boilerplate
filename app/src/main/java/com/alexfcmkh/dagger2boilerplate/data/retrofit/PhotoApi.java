package com.alexfcmkh.dagger2boilerplate.data.retrofit;

import com.alexfcmkh.dagger2boilerplate.data.model.PhotoModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhotoApi {
    @GET("/photos")
    Single<List<PhotoModel>> loadPhotos(@Query("userId") int id);
}
