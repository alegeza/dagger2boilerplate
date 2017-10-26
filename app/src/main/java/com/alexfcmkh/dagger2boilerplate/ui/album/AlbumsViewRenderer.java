package com.alexfcmkh.dagger2boilerplate.ui.album;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.alexfcmkh.dagger2boilerplate.R;
import com.alexfcmkh.dagger2boilerplate.ui.base.BaseViewRenderer;
import com.alexfcmkh.dagger2boilerplate.ui.base.OnListItemClickListener;
import com.alexfcmkh.dagger2boilerplate.ui.model.AlbumItemModel;


public class AlbumsViewRenderer extends BaseViewRenderer<AlbumItemModel, AlbumViewHolder> {

    AlbumsViewRenderer(int viewType, @NonNull Context context, @Nullable OnListItemClickListener<AlbumItemModel> listItemClickListener) {
        super(viewType, context, listItemClickListener);
    }

    @Override
    public void bindView(@NonNull AlbumItemModel model, @NonNull AlbumViewHolder holder) {
        super.bindView(model, holder);
        holder.tvAlbumName.setText(model.getAlbumName());
    }

    @NonNull
    @Override
    public AlbumViewHolder createViewHolder(@Nullable ViewGroup parent) {
        View view = inflate(R.layout.list_item_album, parent);
        return new AlbumViewHolder(view);
    }
}
