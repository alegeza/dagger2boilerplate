package com.alexfcmkh.dagger2boilerplate.mvp.usecase;

import android.support.annotation.NonNull;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

abstract class BaseUseCase<T> {

    Single<T> execute(@NonNull Single<T> single) {
        return single.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation());
    }
}
