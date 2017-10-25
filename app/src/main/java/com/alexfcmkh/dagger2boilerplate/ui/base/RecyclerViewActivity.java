package com.alexfcmkh.dagger2boilerplate.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alexfcmkh.dagger2boilerplate.R;
import com.github.vivchar.rendererrecyclerviewadapter.ItemModel;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class RecyclerViewActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    private RendererRecyclerViewAdapter rendererRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        ButterKnife.bind(this);

        rendererRecyclerViewAdapter = new RendererRecyclerViewAdapter();
        registerRenderers(rendererRecyclerViewAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(rendererRecyclerViewAdapter);
    }

    protected abstract void registerRenderers(RendererRecyclerViewAdapter rendererRecyclerViewAdapter);

    @LayoutRes
    protected int getLayoutId() {
        return R.layout.activity_recycler_view;
    }

    protected void setItems(List<? extends ItemModel> items) {
        rendererRecyclerViewAdapter.setItems(items);
        rendererRecyclerViewAdapter.notifyDataSetChanged();
    }
}
