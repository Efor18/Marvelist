package com.eolalla.marvelist;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.eolalla.marvelist.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        getMarvelApplication().getAppComponent().inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigator.loadCharactersFragment(getSupportFragmentManager());
    }
}
