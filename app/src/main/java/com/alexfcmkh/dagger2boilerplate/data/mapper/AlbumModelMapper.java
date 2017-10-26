package com.alexfcmkh.dagger2boilerplate.data.mapper;

import com.alexfcmkh.dagger2boilerplate.data.model.AlbumModel;
import com.alexfcmkh.dagger2boilerplate.ui.model.AlbumItemModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class AlbumModelMapper {

    @Inject
    public AlbumModelMapper() {
    }

    public List<AlbumItemModel> transform(List<AlbumModel> items) {
        List<AlbumItemModel> result = new ArrayList<>();
        for (AlbumModel item : items) {
            result.add(new AlbumItemModel(item));
        }
        return result;
    }
}
