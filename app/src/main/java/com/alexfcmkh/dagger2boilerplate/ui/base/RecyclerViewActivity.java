package com.alexfcmkh.dagger2boilerplate.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alexfcmkh.dagger2boilerplate.R;
import com.github.vivchar.rendererrecyclerviewadapter.ItemModel;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class RecyclerViewActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.message)
    TextView tvMessage;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private RendererRecyclerViewAdapter rendererRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        ButterKnife.bind(this);

        swipeRefreshLayout.setOnRefreshListener(this);

        rendererRecyclerViewAdapter = new RendererRecyclerViewAdapter();
        registerRenderers(rendererRecyclerViewAdapter);

        recyclerView.setLayoutManager(createLayoutManager());
        recyclerView.setAdapter(rendererRecyclerViewAdapter);
        setupItemDecorator(recyclerView);
    }

    protected RecyclerView.LayoutManager createLayoutManager() {
        return new LinearLayoutManager(this);
    }

    protected void setupItemDecorator(RecyclerView recyclerView) {
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    protected abstract void registerRenderers(RendererRecyclerViewAdapter rendererRecyclerViewAdapter);

    @LayoutRes
    protected int getLayoutId() {
        return R.layout.activity_recycler_view;
    }

    protected void setItems(List<? extends ItemModel> items) {
        swipeRefreshLayout.setRefreshing(false);
        rendererRecyclerViewAdapter.setItems(items);
        rendererRecyclerViewAdapter.notifyDataSetChanged();
    }

    protected void toggleProgressView(Boolean isLoading) {
        int visibility = isLoading ? View.VISIBLE : View.GONE;
        progressBar.setVisibility(visibility);
        swipeRefreshLayout.setRefreshing(false);
    }

    protected void showMessage(String message) {
        swipeRefreshLayout.setRefreshing(false);
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText(message);
    }
}
