package com.eolalla.marvelist;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.eolalla.marvelist.base.ActivityProvider;
import com.eolalla.marvelist.base.BaseActivity;
import com.eolalla.marvelist.injection.component.ActivityComponent;
import com.eolalla.marvelist.injection.component.DaggerActivityComponent;
import com.eolalla.marvelist.injection.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements ActivityProvider {

    @Inject
    Navigator navigator;

    private ActivityComponent daggerActivityComponent;
    private Toolbar toolbar;

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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigator.loadCharactersFragment();
    }

    @Override
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(showHomeAsUp);
        }
    }

    @Override
    public void setActionBarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }
}
