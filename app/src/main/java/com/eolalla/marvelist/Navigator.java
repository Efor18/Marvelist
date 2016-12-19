package com.eolalla.marvelist;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.view.View;

import com.eolalla.marvelist.data.ApiServiceProvider;
import com.eolalla.marvelist.data.model.Character;
import com.eolalla.marvelist.ui.characterDetails.CharacterDetailsFragment;
import com.eolalla.marvelist.ui.characterDetails.CharacterDetailsPresenter;
import com.eolalla.marvelist.ui.charactersList.CharactersListFragment;
import com.eolalla.marvelist.ui.charactersList.CharactersListPresenter;
import com.eolalla.marvelist.utils.DetailsTransition;

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
        CharactersListFragment charactersListFragment = (CharactersListFragment) fragmentManager
                .findFragmentByTag(CharactersListFragment.FRAGMENT_TAG);
        if (charactersListFragment == null) {
            charactersListFragment = CharactersListFragment.newInstance();
            showFragment(charactersListFragment);
        }
        new CharactersListPresenter(charactersListFragment, apiServiceProvider, this);
    }

    public void loadCharacterDetails(Character character, View sharedView) {
        CharacterDetailsFragment characterDetailsFragment = (CharacterDetailsFragment) fragmentManager.findFragmentByTag(CharacterDetailsFragment.FRAGMENT_TAG);
        if (characterDetailsFragment == null) {
            characterDetailsFragment = CharacterDetailsFragment.newInstance();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            characterDetailsFragment.setSharedElementEnterTransition(new DetailsTransition());
        }
        String sharedKey = sharedView.getContext().getString(R.string.transition_shared_element);
        ViewCompat.setTransitionName(sharedView, sharedKey);
        fragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_container, characterDetailsFragment)
                .addSharedElement(sharedView, sharedKey)
                .addToBackStack(null)
                .commit();
        new CharacterDetailsPresenter(characterDetailsFragment, character);
    }

    private void showFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_container, fragment)
                .commit();
    }
}
