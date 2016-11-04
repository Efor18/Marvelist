package com.eolalla.marvelist.injection.component;

import com.eolalla.marvelist.MainActivity;
import com.eolalla.marvelist.Navigator;
import com.eolalla.marvelist.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ernesto Olalla on 26/10/16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(Navigator navigator);


}
