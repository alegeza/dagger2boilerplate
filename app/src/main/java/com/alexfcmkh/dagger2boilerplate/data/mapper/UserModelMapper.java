package com.alexfcmkh.dagger2boilerplate.data.mapper;

import android.support.annotation.NonNull;

import com.alexfcmkh.dagger2boilerplate.data.model.UserModel;
import com.alexfcmkh.dagger2boilerplate.ui.model.UserItemModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class UserModelMapper {

    @Inject
    public UserModelMapper() {
    }

    @NonNull
    public List<UserItemModel> transform(@NonNull List<UserModel> items){
        List<UserItemModel> result = new ArrayList<>();
        for (UserModel item : items) {
            result.add(new UserItemModel(item));
        }
        return result;
    }
}
