package com.eolalla.marvelist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.eolalla.marvelist.characters.CharactersFragment;
import com.eolalla.marvelist.network.ApiServiceProvider;
import com.eolalla.marvelist.characters.CharactersPresenter;

import javax.inject.Inject;

/**
 * Created by Ernesto Olalla on 2/11/16.
 */

public class Navigator {

    private ApiServiceProvider apiServiceProvider;
    private FragmentManager fragmentManager;

    public Navigator(ApiServiceProvider apiServiceProvider, FragmentManager fragmentManager) {
        this.apiServiceProvider = apiServiceProvider;
        this.fragmentManager = fragmentManager;
    }

    public void loadCharactersFragment() {
        CharactersFragment charactersFragment = (CharactersFragment) fragmentManager
                .findFragmentByTag(CharactersFragment.FRAGMENT_TAG);
        if (charactersFragment == null) {
            charactersFragment = CharactersFragment.newInstance();
            showFragment(charactersFragment);
        }
        new CharactersPresenter(charactersFragment, apiServiceProvider);
    }

    private void showFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_container, fragment)
                .commit();
    }
}
