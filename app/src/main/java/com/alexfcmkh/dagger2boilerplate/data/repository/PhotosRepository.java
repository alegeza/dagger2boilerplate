package com.alexfcmkh.dagger2boilerplate.data.repository;

import android.support.annotation.Nullable;

import com.alexfcmkh.dagger2boilerplate.data.model.PhotoModel;
import com.alexfcmkh.dagger2boilerplate.data.repository.query.request.Query;
import com.alexfcmkh.dagger2boilerplate.data.retrofit.PhotoApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class PhotosRepository implements IBaseRepository<PhotoModel> {

    private PhotoApi photoApi;

    @Inject
    public PhotosRepository(PhotoApi photoApi) {
        this.photoApi = photoApi;
    }

    @Override
    public Single<List<PhotoModel>> getAllData(@Nullable Query query) {
        return photoApi.loadPhotos(query.getId());
    }
}
