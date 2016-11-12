package com.eolalla.marvelist.injection.component;

import com.eolalla.marvelist.injection.module.ApplicationModule;
import com.eolalla.marvelist.network.ApiServiceProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ernesto Olalla on 26/10/16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    ApiServiceProvider apiServiceProvider();

}
