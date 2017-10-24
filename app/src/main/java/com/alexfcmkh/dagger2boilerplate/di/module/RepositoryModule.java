package com.alexfcmkh.dagger2boilerplate.di.module;

import com.alexfcmkh.dagger2boilerplate.data.repository.IBaseRepository;
import com.alexfcmkh.dagger2boilerplate.data.repository.UsersRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoryModule {

    @Singleton
    @Binds
    public abstract IBaseRepository bindUsersRepository(UsersRepository repository);

}
