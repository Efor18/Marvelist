package com.eolalla.marvelist.characters;

import com.eolalla.marvelist.network.ApiServiceProvider;
import com.eolalla.marvelist.network.model.Character;
import com.eolalla.marvelist.network.model.CharacterDataWrapper;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by Ernesto Olalla on 2/11/16.
 */

public class CharactersPresenter implements CharactersContract.Presenter {

    @Inject
    ApiServiceProvider apiServiceProvider;

    private CharactersContract.View view;
    private int offset = 0;

    public CharactersPresenter(CharactersContract.View charactersView, ApiServiceProvider apiServiceProvider) {
        this.view = charactersView;
        this.apiServiceProvider = apiServiceProvider;
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
}
