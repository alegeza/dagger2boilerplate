package com.alexfcmkh.dagger2boilerplate.data.repository;

import android.support.annotation.Nullable;

import com.alexfcmkh.dagger2boilerplate.data.model.AlbumModel;
import com.alexfcmkh.dagger2boilerplate.data.repository.query.request.Query;
import com.alexfcmkh.dagger2boilerplate.data.retrofit.AlbumApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class AlbumsRepository implements IBaseRepository<AlbumModel> {

    private AlbumApi albumApi;

    @Inject
    public AlbumsRepository(AlbumApi albumApi) {
        this.albumApi = albumApi;
    }

    @Override
    public Single<List<AlbumModel>> getAllData(@Nullable Query query) {
        int id = query == null ? 0 : query.getId();
        return albumApi.loadAlbums(id);
    }
}
