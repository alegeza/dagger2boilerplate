package com.alexfcmkh.dagger2boilerplate.data.repository;

import android.support.annotation.Nullable;

import com.alexfcmkh.dagger2boilerplate.data.repository.query.request.Query;

import java.util.List;

import io.reactivex.Single;

public interface IBaseRepository<T> {
    Single<List<T>> getAllData(@Nullable Query query);
}
