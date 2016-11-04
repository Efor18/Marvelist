package com.eolalla.marvelist.characters;

import android.util.Log;

import com.eolalla.marvelist.network.ApiServiceProvider;
import com.eolalla.marvelist.network.model.CharacterDataWrapper;
import com.eolalla.marvelist.network.model.Character;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ernesto Olalla on 2/11/16.
 */

public class CharactersPresenter implements CharactersContract.Presenter {

    @Inject
    ApiServiceProvider apiServiceProvider;

    private CharactersContract.View view;

    public CharactersPresenter(CharactersContract.View charactersView, ApiServiceProvider apiServiceProvider) {
        this.view = charactersView;
        this.apiServiceProvider = apiServiceProvider;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        loadCharacters();
    }

    private void loadCharacters() {
        view.showLoading(true);
        apiServiceProvider.provideMarvelService().getCharacters().enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                Log.d("Erne", "Success!!");

                for (Character character : response.body().getData().getCharacters()) {
                    Log.d("Erne", character.getName() + " - " + character.getDescription());
                }
                view.populateCharacters(response.body().getData().getCharacters());
                view.showLoading(false);
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                Log.e("Erne", "Error! " + t.getMessage());
                view.showLoading(false);
            }
        });
    }
}
