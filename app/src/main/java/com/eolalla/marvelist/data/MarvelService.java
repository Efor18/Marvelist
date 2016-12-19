package com.eolalla.marvelist.data;


import com.eolalla.marvelist.data.model.CharacterDataWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ernesto Olalla on 26/10/16.
 */

public interface MarvelService {

    @GET("characters")
    Call<CharacterDataWrapper> getCharacters(@Query("offset") int offset);
}
