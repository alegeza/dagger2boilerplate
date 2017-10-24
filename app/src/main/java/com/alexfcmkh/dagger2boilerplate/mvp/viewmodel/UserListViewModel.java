package com.alexfcmkh.dagger2boilerplate.mvp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.alexfcmkh.dagger2boilerplate.data.model.UserModel;
import com.alexfcmkh.dagger2boilerplate.mvp.usecase.UserUseCase;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;


public class UserListViewModel extends ViewModel {

    private UserUseCase userUseCase;
    private MutableLiveData<List<UserModel>> usersLiveData;

    @Inject
    public UserListViewModel(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    public void loadUsers() {
        userUseCase.loadUsers().subscribe(this::setUsers, this::logError);
    }

    public LiveData<List<UserModel>> getUsers() {
        if (usersLiveData == null) {
            usersLiveData = new MutableLiveData<>();
        }
        return usersLiveData;
    }

    private void setUsers(List<UserModel> users) {
        if (usersLiveData == null) {
            usersLiveData = new MutableLiveData<>();
        }
        usersLiveData.setValue(users);
    }

    private void logError(Throwable throwable) {
        Timber.e(throwable);
    }
}
