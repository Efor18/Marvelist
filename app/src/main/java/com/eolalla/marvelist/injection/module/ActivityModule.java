package com.eolalla.marvelist.injection.module;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.eolalla.marvelist.Navigator;
import com.eolalla.marvelist.injection.scope.ActivityScope;
import com.eolalla.marvelist.data.ApiServiceProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (c) 2016 DigitasLBi. All rights reserved.
 * Created on 12/11/2016.
 */

@Module
public class ActivityModule {

    private FragmentActivity activity;

    public ActivityModule(FragmentActivity activity) {
        this.activity = activity;
    }

    @Provides
    FragmentManager provideFragmentManager() {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @ActivityScope
    Navigator provideNavigator(ApiServiceProvider apiServiceProvider, FragmentManager fragmentManager) {
        return new Navigator(apiServiceProvider, fragmentManager);
    }

}
