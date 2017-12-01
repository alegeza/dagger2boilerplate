package com.alexfcmkh.dagger2boilerplate.mvp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.alexfcmkh.dagger2boilerplate.data.mapper.UserModelMapper;
import com.alexfcmkh.dagger2boilerplate.data.model.UserModel;
import com.alexfcmkh.dagger2boilerplate.mvp.usecase.UserUseCase;
import com.alexfcmkh.dagger2boilerplate.ui.model.UserItemModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;


public class UserListViewModel extends BaseViewModel {

    private UserUseCase userUseCase;
    private UserModelMapper mapper;
    private MutableLiveData<List<UserItemModel>> userModelsLiveData;

    @Inject
    UserListViewModel(UserUseCase userUseCase, UserModelMapper mapper) {
        this.userUseCase = userUseCase;
        this.mapper = mapper;
    }

    public void loadUsers() {
        getLoadingProgressLiveData().setValue(true);
        getInfoMessageLiveData().setValue(null);
        userUseCase.loadUsers().subscribe(this::setUsers, this::logError);
    }

    public LiveData<List<UserItemModel>> getUsers() {
        if (userModelsLiveData == null) {
            userModelsLiveData = new MutableLiveData<>();
        }
        return userModelsLiveData;
    }

    private void setUsers(List<UserModel> users) {
        if (userModelsLiveData == null) {
            userModelsLiveData = new MutableLiveData<>();
        }
        getLoadingProgressLiveData().setValue(false);
        userModelsLiveData.setValue(mapper.transform(users));
    }

    private void logError(Throwable throwable) {
        getLoadingProgressLiveData().setValue(false);
        userModelsLiveData.setValue(new ArrayList<>());
        getInfoMessageLiveData().setValue("Could not load users due to error");
        Timber.e(throwable);
    }
}
