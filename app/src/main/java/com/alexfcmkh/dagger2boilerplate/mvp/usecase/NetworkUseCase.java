package com.alexfcmkh.dagger2boilerplate.mvp.usecase;

import android.support.annotation.NonNull;

import com.alexfcmkh.dagger2boilerplate.exception.NoConnectionException;
import com.alexfcmkh.dagger2boilerplate.util.NetworkInteractor;

import io.reactivex.Single;

public abstract class NetworkUseCase<T> extends BaseUseCase<T> {

    private NetworkInteractor networkInteractor;

    public NetworkUseCase(NetworkInteractor networkInteractor) {
        this.networkInteractor = networkInteractor;
    }

    @Override
    Single<T> execute(@NonNull Single<T> single) {
        return Single.defer(() -> {
            if (!networkInteractor.isNetworkAvailable()) {
                return Single.error(new NoConnectionException());
            }
            return super.execute(single);
        });
    }
}
