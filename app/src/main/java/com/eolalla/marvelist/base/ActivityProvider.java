package com.eolalla.marvelist.base;

/**
 * Created by Ernesto Olalla on 19/12/16.
 * <p>
 * Common interface between activities and fragments.
 */
public interface ActivityProvider {

    void setDisplayHomeAsUpEnabled(boolean showHomeAsUp);

    void setActionBarTitle(String title);
}
