package com.alexfcmkh.dagger2boilerplate.data.retrofit;

import com.alexfcmkh.dagger2boilerplate.data.model.AlbumModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlbumApi {
    @GET("/albums")
    Single<List<AlbumModel>> loadAlbums(@Query("userId") int id);
}
