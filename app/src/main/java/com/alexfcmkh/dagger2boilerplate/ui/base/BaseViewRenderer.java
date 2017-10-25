package com.alexfcmkh.dagger2boilerplate.ui.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.github.vivchar.rendererrecyclerviewadapter.ItemModel;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;


public abstract class BaseViewRenderer<M extends ItemModel, VH extends RecyclerView.ViewHolder> extends ViewRenderer<M, VH> {

    private OnListItemClickListener listItemClickListener;

    public BaseViewRenderer(int viewType, @NonNull Context context, @Nullable OnListItemClickListener listItemClickListener) {
        super(viewType, context);
        this.listItemClickListener = listItemClickListener;
    }

    @Nullable
    public OnListItemClickListener getListItemClickListener() {
        return listItemClickListener;
    }
}
