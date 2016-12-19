package com.eolalla.marvelist.ui.charactersList;

import android.view.View;

import com.eolalla.marvelist.Navigator;
import com.eolalla.marvelist.data.ApiServiceProvider;
import com.eolalla.marvelist.data.model.Character;
import com.eolalla.marvelist.data.model.CharacterDataWrapper;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by Ernesto Olalla on 2/11/16.
 */

public class CharactersListPresenter implements CharactersListContract.Presenter {

    @Inject
    ApiServiceProvider apiServiceProvider;

    private CharactersListContract.View view;
    private final Navigator navigator;
    private int offset = 0;

    public CharactersListPresenter(CharactersListContract.View charactersView, ApiServiceProvider apiServiceProvider, Navigator navigator) {
        this.view = charactersView;
        this.apiServiceProvider = apiServiceProvider;
        this.navigator = navigator;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        loadCharacters();
    }

    @Override
    public void loadCharacters() {
        apiServiceProvider.provideMarvelService().getCharacters(offset).enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                List<Character> characters = response.body().getData().getCharacters();
                for (Character character : characters) {
                    Timber.d(character.getName() + " - " + character.getDescription());
                }
                offset += characters.size();
                int total = response.body().getData().getTotal();
                view.populateCharacters(characters, total);
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                Timber.e(t, "Error: " + t.getMessage());
            }
        });
    }

    @Override
    public void loadCharacterDetails(Character character, View sharedView) {
        navigator.loadCharacterDetails(character, sharedView);
    }
}
