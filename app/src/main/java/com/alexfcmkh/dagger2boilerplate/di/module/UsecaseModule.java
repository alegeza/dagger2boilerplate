package com.alexfcmkh.dagger2boilerplate.di.module;

import com.alexfcmkh.dagger2boilerplate.data.repository.UsersRepository;
import com.alexfcmkh.dagger2boilerplate.mvp.usecase.UserUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class UsecaseModule {

    @Provides
    UserUseCase provideUsersUsecase(UsersRepository repository) {
        return new UserUseCase(repository);
    }

}
