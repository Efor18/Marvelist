package com.eolalla.marvelist.ui.characterDetails;

import com.eolalla.marvelist.data.model.Character;

/**
 * Created by Ernesto Olalla on 19/12/16.
 */

public class CharacterDetailsPresenter implements CharacterDetailsContract.Presenter {

    private CharacterDetailsContract.View view;
    private Character character;

    public CharacterDetailsPresenter(CharacterDetailsContract.View view, Character character) {
        this.view = view;
        this.character = character;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        view.populateCharacter(character);
    }
}
