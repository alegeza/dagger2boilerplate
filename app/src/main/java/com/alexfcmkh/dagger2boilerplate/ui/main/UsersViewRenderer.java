package com.alexfcmkh.dagger2boilerplate.ui.main;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.alexfcmkh.dagger2boilerplate.R;
import com.alexfcmkh.dagger2boilerplate.ui.base.BaseViewRenderer;
import com.alexfcmkh.dagger2boilerplate.ui.base.OnListItemClickListener;
import com.alexfcmkh.dagger2boilerplate.ui.model.UserItemModel;


public class UsersViewRenderer extends BaseViewRenderer<UserItemModel, UserViewHolder> {

    UsersViewRenderer(int viewType, @NonNull Context context, OnListItemClickListener<UserItemModel> listItemClickListener) {
        super(viewType, context, listItemClickListener);
    }

    @Override
    public void bindView(@NonNull final UserItemModel model, @NonNull UserViewHolder holder) {
        super.bindView(model, holder);
        holder.tvUserName.setText(model.getUserName());
    }

    @NonNull
    @Override
    public UserViewHolder createViewHolder(@Nullable ViewGroup parent) {
        View view = inflate(R.layout.list_item_user, parent);
        return new UserViewHolder(view);
    }
}
