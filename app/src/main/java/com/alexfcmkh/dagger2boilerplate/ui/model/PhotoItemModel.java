package com.alexfcmkh.dagger2boilerplate.ui.model;

import com.alexfcmkh.dagger2boilerplate.data.model.PhotoModel;
import com.github.vivchar.rendererrecyclerviewadapter.ItemModel;


public class PhotoItemModel implements ItemModel {

    public static final int PHOTO_LIST_ITEM_TYPE = 3;

    private final PhotoModel photoModel;

    public PhotoItemModel(PhotoModel item) {
        this.photoModel = item;
    }

    public String getThumbnailUrl() {
        return photoModel.getThumbnailUrl();
    }

    @Override
    public int getType() {
        return PHOTO_LIST_ITEM_TYPE;
    }

}
