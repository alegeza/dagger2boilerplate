package com.alexfcmkh.dagger2boilerplate.ui.photo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.alexfcmkh.dagger2boilerplate.R;
import com.alexfcmkh.dagger2boilerplate.ui.base.BaseViewRenderer;
import com.alexfcmkh.dagger2boilerplate.ui.model.PhotoItemModel;
import com.squareup.picasso.Picasso;


public class PhotoViewRenderer extends BaseViewRenderer<PhotoItemModel, PhotoViewHolder> {

    PhotoViewRenderer(int viewType, @NonNull Context context) {
        super(viewType, context);
    }

    @Override
    public void bindView(@NonNull PhotoItemModel model, @NonNull PhotoViewHolder holder) {
        super.bindView(model, holder);
        Picasso.with(getContext()).load(model.getThumbnailUrl()).into(holder.ivPhoto);
    }

    @NonNull
    @Override
    public PhotoViewHolder createViewHolder(@Nullable ViewGroup parent) {
        return new PhotoViewHolder(inflate(R.layout.grid_item_photo, parent));
    }
}
