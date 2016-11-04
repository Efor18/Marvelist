package com.eolalla.marvelist.network;


import com.eolalla.marvelist.network.model.CharacterDataWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ernesto Olalla on 26/10/16.
 */

public interface MarvelService {

    @GET("characters")
    Call<CharacterDataWrapper> getCharacters();
}
