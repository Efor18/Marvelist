package com.eolalla.marvelist.injection.component;

import com.eolalla.marvelist.MainActivity;
import com.eolalla.marvelist.injection.module.ActivityModule;
import com.eolalla.marvelist.injection.scope.ActivityScope;

import dagger.Component;

/**
 * Copyright (c) 2016 DigitasLBi. All rights reserved.
 * Created on 12/11/2016.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
