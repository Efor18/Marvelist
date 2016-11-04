package com.eolalla.marvelist.characters;

import com.eolalla.marvelist.base.BasePresenter;
import com.eolalla.marvelist.base.BaseView;
import com.eolalla.marvelist.network.model.Character;

import java.util.List;

/**
 * Created by Ernesto Olalla on 2/11/16.
 */

public interface CharactersContract {

    interface View extends BaseView<Presenter> {
        void showLoading(boolean showLoading);

        void populateCharacters(List<Character> characters);
    }

    interface Presenter extends BasePresenter {
    }
}
