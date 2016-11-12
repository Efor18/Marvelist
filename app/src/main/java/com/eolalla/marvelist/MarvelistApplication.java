package com.eolalla.marvelist;

import android.app.Application;

import com.eolalla.marvelist.injection.component.ApplicationComponent;
import com.eolalla.marvelist.injection.component.DaggerApplicationComponent;
import com.eolalla.marvelist.injection.module.ApplicationModule;

import timber.log.Timber;

/**
 * Created by Ernesto Olalla on 26/10/16.
 */
public class MarvelistApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDependency();
        initTimber();
    }

    private void initDependency() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ApplicationComponent getAppComponent() {
        return applicationComponent;
    }
}
