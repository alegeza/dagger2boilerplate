package com.alexfcmkh.dagger2boilerplate.ui.photo;

import android.view.View;
import android.widget.ImageView;

import com.alexfcmkh.dagger2boilerplate.R;
import com.alexfcmkh.dagger2boilerplate.ui.base.BaseViewHolder;

import butterknife.BindView;


class PhotoViewHolder extends BaseViewHolder {

    @BindView(R.id.item_photo)
    ImageView ivPhoto;

    PhotoViewHolder(View itemView) {
        super(itemView);
    }
}
