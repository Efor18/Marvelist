package com.eolalla.marvelist.ui.characterDetails;

import com.eolalla.marvelist.base.BasePresenter;
import com.eolalla.marvelist.base.BaseView;
import com.eolalla.marvelist.data.model.Character;

/**
 * Created by Ernesto Olalla on 19/12/16.
 */

public class CharacterDetailsContract {

    interface View extends BaseView<Presenter> {
        void populateCharacter(Character character);
    }

    interface Presenter extends BasePresenter {
    }
}
