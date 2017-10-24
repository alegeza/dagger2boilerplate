package com.alexfcmkh.dagger2boilerplate.data.repository;

import java.util.List;

import io.reactivex.Single;

public interface IBaseRepository<T> {
    Single<List<T>> getAllData();
}
