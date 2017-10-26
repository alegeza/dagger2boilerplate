package com.alexfcmkh.dagger2boilerplate.mvp.usecase;

import com.alexfcmkh.dagger2boilerplate.data.model.PhotoModel;
import com.alexfcmkh.dagger2boilerplate.data.repository.PhotosRepository;
import com.alexfcmkh.dagger2boilerplate.data.repository.query.request.Query;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class LoadPhotosUseCase extends BaseUseCase<List<PhotoModel>> {

    private PhotosRepository repository;

    @Inject
    public LoadPhotosUseCase(PhotosRepository repository) {
        this.repository = repository;
    }

    public Single<List<PhotoModel>> getAllPhotos(int albumId) {
        Query query = new Query(albumId);
        return execute(repository.getAllData(query));
    }
}
