package com.eolalla.marvelist.ui.charactersList;

import com.eolalla.marvelist.base.BasePresenter;
import com.eolalla.marvelist.base.BaseView;
import com.eolalla.marvelist.data.model.Character;

import java.util.List;

/**
 * Created by Ernesto Olalla on 2/11/16.
 */

public interface CharactersListContract {

    interface View extends BaseView<Presenter> {

        void populateCharacters(List<Character> characters, int total);
    }

    interface Presenter extends BasePresenter {
        void loadCharacters();

        void loadCharacterDetails(Character character, android.view.View sharedView);
    }
}
