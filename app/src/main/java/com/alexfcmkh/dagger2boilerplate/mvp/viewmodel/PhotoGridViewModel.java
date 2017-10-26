package com.alexfcmkh.dagger2boilerplate.mvp.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.alexfcmkh.dagger2boilerplate.data.mapper.PhotoModelMapper;
import com.alexfcmkh.dagger2boilerplate.data.model.PhotoModel;
import com.alexfcmkh.dagger2boilerplate.mvp.usecase.LoadPhotosUseCase;
import com.alexfcmkh.dagger2boilerplate.ui.model.PhotoItemModel;

import java.util.List;

import javax.inject.Inject;


public class PhotoGridViewModel extends ViewModel {

    private final LoadPhotosUseCase loadPhotosUseCase;
    private final PhotoModelMapper mapper;


    private MutableLiveData<List<PhotoItemModel>> photosLiveData;

    @Inject
    public PhotoGridViewModel(LoadPhotosUseCase loadPhotosUseCase, PhotoModelMapper photoModelMapper) {
        this.loadPhotosUseCase = loadPhotosUseCase;
        this.mapper = photoModelMapper;
    }

    public void loadPhotos(int albumId) {
        loadPhotosUseCase.getAllPhotos(albumId)
                .subscribe(this::setPhotos, throwable -> {
                });

    }

    private void setPhotos(List<PhotoModel> photos) {
        if (photosLiveData == null) {
            photosLiveData = new MutableLiveData<>();
        }
        photosLiveData.setValue(mapper.transform(photos));
    }

    public MutableLiveData<List<PhotoItemModel>> getPhotosLiveData() {
        if (photosLiveData == null) {
            photosLiveData = new MutableLiveData<>();
        }
        return photosLiveData;
    }
}
