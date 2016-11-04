package com.eolalla.marvelist.base;

import android.support.v7.app.AppCompatActivity;

import com.eolalla.marvelist.MarvelistApplication;

/**
 * Created by Ernesto Olalla on 26/10/16.
 */
public class BaseActivity extends AppCompatActivity {

    protected MarvelistApplication getMarvelApplication() {
        return (MarvelistApplication) getApplication();
    }
}
