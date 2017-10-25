package com.alexfcmkh.dagger2boilerplate.ui.main;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.alexfcmkh.dagger2boilerplate.ui.base.BaseViewRenderer;
import com.alexfcmkh.dagger2boilerplate.ui.model.UserItemModel;


public class UsersViewRenderer extends BaseViewRenderer<UserItemModel, UserViewHolder> {

    public UsersViewRenderer(int viewType, @NonNull Context context) {
        super(viewType, context, null);
    }

    @Override
    public void bindView(@NonNull final UserItemModel model, @NonNull UserViewHolder holder) {
        holder.itemView.setOnClickListener(v -> {
            if (getListItemClickListener() != null) {
                getListItemClickListener().onItemClicked(model);
            }
        });
    }

    @NonNull
    @Override
    public UserViewHolder createViewHolder(@Nullable ViewGroup parent) {
        return null;
    }
}
