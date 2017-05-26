package com.alexfcmkh.dagger2boilerplate.data.repository;

import java.util.List;

import io.reactivex.Observable;

public interface IBaseRepository<T> {


    Observable<List<T>> getAllData();


}
