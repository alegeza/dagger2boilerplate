package com.alexfcmkh.dagger2boilerplate.ui.model;

import com.alexfcmkh.dagger2boilerplate.data.model.UserModel;
import com.github.vivchar.rendererrecyclerviewadapter.ItemModel;


public class UserItemModel implements ItemModel {


    public static final int USER_LIST_ITEM_TYPE = 1;

    private final UserModel userModel;

    public UserItemModel(UserModel item) {
        this.userModel = item;
    }

    public int getUserId(){
        return userModel.getId();
    }

    public String getUserName() {
        return userModel.getName();
    }

    @Override
    public int getType() {
        return USER_LIST_ITEM_TYPE;
    }
}
