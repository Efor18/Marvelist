package com.eolalla.marvelist;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.eolalla.marvelist.base.BaseActivity;
import com.eolalla.marvelist.injection.component.ActivityComponent;
import com.eolalla.marvelist.injection.component.DaggerActivityComponent;
import com.eolalla.marvelist.injection.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    Navigator navigator;

    private ActivityComponent daggerActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        daggerActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getMarvelApplication().getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
        daggerActivityComponent.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigator.loadCharactersFragment();
    }
}
