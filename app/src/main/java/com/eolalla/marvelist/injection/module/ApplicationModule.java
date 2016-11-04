package com.eolalla.marvelist.injection.module;

import com.eolalla.marvelist.MarvelistApplication;
import com.eolalla.marvelist.network.ApiServiceProvider;
import com.eolalla.marvelist.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ernesto Olalla on 26/10/16.
 */
@Module
public class ApplicationModule {

    private final MarvelistApplication application;

    public ApplicationModule(MarvelistApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    ApiServiceProvider provideApiServiceProvider() {
        return new ApiServiceProvider().init();
    }

    @Provides
    @Singleton
    Navigator provideNavigator(){
        return new Navigator(application);
    }
}
