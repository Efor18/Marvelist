package com.eolalla.marvelist.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionSet;
import android.util.AttributeSet;

/**
 * Created by Ernesto Olalla on 12/12/16.
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class DetailsTransition extends TransitionSet {

    private static final long ANIMATION_DURATION = 500;

    public DetailsTransition() {
        init();
    }

    /**
     * This constructor allows us to use this transition in XML
     */
    public DetailsTransition(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOrdering(ORDERING_TOGETHER);
        setDuration(ANIMATION_DURATION);
        addTransition(new ChangeImageTransform());
        addTransition(new ChangeBounds());
        addTransition(new ChangeTransform());
    }
}