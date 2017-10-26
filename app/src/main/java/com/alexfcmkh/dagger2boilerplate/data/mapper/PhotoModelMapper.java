package com.alexfcmkh.dagger2boilerplate.data.mapper;

import com.alexfcmkh.dagger2boilerplate.data.model.PhotoModel;
import com.alexfcmkh.dagger2boilerplate.ui.model.PhotoItemModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PhotoModelMapper {

    @Inject
    public PhotoModelMapper() {
    }

    public List<PhotoItemModel> transform(List<PhotoModel> items) {
        List<PhotoItemModel> result = new ArrayList<>();
        for (PhotoModel item : items) {
            result.add(new PhotoItemModel(item));
        }
        return result;
    }
}
