package com.eolalla.marvelist.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by Ernesto Olalla on 2/11/16.
 */

public class BaseFragment extends Fragment {

    private ActivityProvider activityProvider;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activityProvider = (ActivityProvider) activity;
    }

    protected void setDisplayHomeAsUpEnabled(boolean homeAsUpEnabled) {
        activityProvider.setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    protected void setActionBarTitle(String title) {
        activityProvider.setActionBarTitle(title);
    }

}
