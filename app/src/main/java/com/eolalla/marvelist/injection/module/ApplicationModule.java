package com.eolalla.marvelist.injection.module;

import com.eolalla.marvelist.MarvelistApplication;
import com.eolalla.marvelist.network.ApiServiceProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ernesto Olalla on 26/10/16.
 */
@Module
public class ApplicationModule {

    private MarvelistApplication application;

    public ApplicationModule(MarvelistApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    ApiServiceProvider provideApiServiceProvider() {
        return new ApiServiceProvider().init();
    }

}
