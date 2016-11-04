package com.eolalla.marvelist;

import android.app.Application;

import com.eolalla.marvelist.injection.component.ApplicationComponent;
import com.eolalla.marvelist.injection.component.DaggerApplicationComponent;
import com.eolalla.marvelist.injection.module.ApplicationModule;

/**
 * Created by Ernesto Olalla on 26/10/16.
 */
public class MarvelistApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDependency();
    }

    private void initDependency() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return applicationComponent;
    }
}
