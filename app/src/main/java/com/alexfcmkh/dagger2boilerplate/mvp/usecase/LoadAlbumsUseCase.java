package com.alexfcmkh.dagger2boilerplate.mvp.usecase;

import com.alexfcmkh.dagger2boilerplate.data.model.AlbumModel;
import com.alexfcmkh.dagger2boilerplate.data.repository.AlbumsRepository;
import com.alexfcmkh.dagger2boilerplate.data.repository.query.request.Query;
import com.alexfcmkh.dagger2boilerplate.util.NetworkInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class LoadAlbumsUseCase extends NetworkUseCase<List<AlbumModel>> {

    private AlbumsRepository repository;

    @Inject
    public LoadAlbumsUseCase(AlbumsRepository repository, NetworkInteractor networkInteractor) {
        super(networkInteractor);
        this.repository = repository;
    }

    public Single<List<AlbumModel>> loadAlbums(int id) {
        Query query = new Query(id);
        return execute(repository.getAllData(query));
    }
}
