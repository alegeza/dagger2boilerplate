package com.alexfcmkh.dagger2boilerplate.mvp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.alexfcmkh.dagger2boilerplate.data.mapper.AlbumModelMapper;
import com.alexfcmkh.dagger2boilerplate.data.model.AlbumModel;
import com.alexfcmkh.dagger2boilerplate.mvp.usecase.LoadAlbumsUseCase;
import com.alexfcmkh.dagger2boilerplate.ui.model.AlbumItemModel;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;


public class AlbumsListViewModel extends ViewModel {

    private LoadAlbumsUseCase loadAlbumsUseCase;
    private AlbumModelMapper mapper;
    private MutableLiveData<List<AlbumItemModel>> albumModelsLiveData;
    private int userId;

    @Inject
    public AlbumsListViewModel(LoadAlbumsUseCase loadAlbumsUseCase, AlbumModelMapper mapper) {
        this.loadAlbumsUseCase = loadAlbumsUseCase;
        this.mapper = mapper;
    }

    public void loadAlbums() {
        loadAlbumsUseCase.loadAlbums(userId).subscribe(this::setAlbums, this::logError);
    }

    public LiveData<List<AlbumItemModel>> getAlbums() {
        if (albumModelsLiveData == null) {
            albumModelsLiveData = new MutableLiveData<>();
        }
        return albumModelsLiveData;
    }

    private void setAlbums(List<AlbumModel> albums) {
        if (albumModelsLiveData == null) {
            albumModelsLiveData = new MutableLiveData<>();
        }
        albumModelsLiveData.setValue(mapper.transform(albums));
    }

    private void logError(Throwable throwable) {
        Timber.e(throwable);
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
