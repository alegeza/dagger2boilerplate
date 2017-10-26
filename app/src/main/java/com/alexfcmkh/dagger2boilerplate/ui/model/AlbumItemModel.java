package com.alexfcmkh.dagger2boilerplate.ui.model;

import com.alexfcmkh.dagger2boilerplate.data.model.AlbumModel;
import com.github.vivchar.rendererrecyclerviewadapter.ItemModel;


public class AlbumItemModel implements ItemModel {

    public static final int ALBUM_LIST_ITEM_TYPE = 2;

    private AlbumModel albumModel;

    public AlbumItemModel(AlbumModel item) {
        this.albumModel = item;
    }

    public int getAlbumId() {
        return albumModel.getId();
    }

    public String getAlbumName() {
        return albumModel.getTitle();
    }

    @Override
    public int getType() {
        return ALBUM_LIST_ITEM_TYPE;
    }
}
