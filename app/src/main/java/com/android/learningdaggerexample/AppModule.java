package com.android.learningdaggerexample;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    public River provideRiver()
    {
        return new River();
    }
}
