package com.example.pokemonapi.proxy.api;

import com.example.pokemonapi.model.thirdparty.PokemonListResponse;
import com.example.pokemonapi.model.thirdparty.PokemonResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeApi {

    @GET("pokemon")
    Call<PokemonListResponse> pokemonList();

    @GET("pokemon/{id}")
    Call<PokemonResponse> getPokemonById(@Path("id") String id);

}
