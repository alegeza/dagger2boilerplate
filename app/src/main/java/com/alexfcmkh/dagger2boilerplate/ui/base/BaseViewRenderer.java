package com.alexfcmkh.dagger2boilerplate.ui.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.github.vivchar.rendererrecyclerviewadapter.ItemModel;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;


public abstract class BaseViewRenderer<M extends ItemModel, VH extends RecyclerView.ViewHolder> extends ViewRenderer<M, VH> {

    private final OnListItemClickListener<M> listItemClickListener;

    public BaseViewRenderer(int viewType, @NonNull Context context, @Nullable OnListItemClickListener<M> listItemClickListener) {
        super(viewType, context);
        this.listItemClickListener = listItemClickListener;
    }

    public BaseViewRenderer(int viewType, @NonNull Context context) {
        this(viewType, context, null);
    }

    @Override
    public void bindView(@NonNull M model, @NonNull VH holder) {
        holder.itemView.setOnClickListener(v -> {
            if (listItemClickListener != null) {
                listItemClickListener.onItemClicked(model);
            }
        });
    }
}
