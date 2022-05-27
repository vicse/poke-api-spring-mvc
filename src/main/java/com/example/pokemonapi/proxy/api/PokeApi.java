package com.example.pokemonapi.proxy.api;

import com.example.pokemonapi.model.thirdparty.EvolutionChainResponse;
import com.example.pokemonapi.model.thirdparty.PokemonListResponse;
import com.example.pokemonapi.model.thirdparty.PokemonResponse;
import com.example.pokemonapi.model.thirdparty.PokemonSpecieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeApi {

    @GET("pokemon")
    Call<PokemonListResponse> pokemonList();

    @GET("pokemon/{id}")
    Call<PokemonResponse> getPokemonById(@Path("id") String id);

    @GET("pokemon/{name}")
    Call<PokemonResponse> getPokemonByName(@Path("name") String name);

    @GET("evolution-chain/{pokemonId}")
    Call<EvolutionChainResponse> getEvolutionChain(@Path("pokemonId") String pokemonId);

    @GET("pokemon-species/{pokemonId}")
    Call<PokemonSpecieResponse> getPokemonSpecieByPokemonId(@Path("pokemonId") String pokemonId);

}
