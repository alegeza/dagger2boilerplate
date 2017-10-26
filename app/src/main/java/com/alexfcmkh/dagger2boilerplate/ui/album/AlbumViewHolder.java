package com.alexfcmkh.dagger2boilerplate.ui.album;

import android.view.View;
import android.widget.TextView;

import com.alexfcmkh.dagger2boilerplate.R;
import com.alexfcmkh.dagger2boilerplate.ui.base.BaseViewHolder;

import butterknife.BindView;


class AlbumViewHolder extends BaseViewHolder {

    @BindView(R.id.album_name)
    TextView tvAlbumName;

    AlbumViewHolder(View itemView) {
        super(itemView);
    }
}
