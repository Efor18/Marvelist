package com.eolalla.marvelist.base;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.eolalla.marvelist.MarvelistApplication;

/**
 * Created by Ernesto Olalla on 26/10/16.
 */
public class BaseActivity extends AppCompatActivity {

    protected MarvelistApplication getMarvelApplication() {
        return (MarvelistApplication) getApplication();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
