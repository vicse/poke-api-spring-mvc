package com.example.pokemonapi.proxy.impl;

import com.example.pokemonapi.model.thirdparty.EvolutionChainResponse;
import com.example.pokemonapi.model.thirdparty.PokemonListResponse;
import com.example.pokemonapi.model.thirdparty.PokemonResponse;
import com.example.pokemonapi.model.thirdparty.PokemonSpecieResponse;
import com.example.pokemonapi.proxy.api.PokeApi;
import com.example.pokemonapi.proxy.service.PokeService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Response;

@Service
@RequiredArgsConstructor
@Slf4j
public class PokeServiceImpl implements PokeService {

    private final PokeApi pokeApi;

    @Override
    public PokemonListResponse getAllPokemon() throws IOException {
        Response<PokemonListResponse> response = pokeApi.pokemonList().execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null ? response.errorBody().string() : "Unknown error");
        }
        return response.body();
    }

    @Override
    public PokemonResponse getPokemonById(String id) throws IOException {
        Response<PokemonResponse> response = pokeApi.getPokemonById(id).execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null ? response.errorBody().string() : "Unknown error");
        }
        return response.body();
    }

    @Override
    public PokemonResponse getPokemonByName(String name) throws IOException {
        Response<PokemonResponse> response = pokeApi.getPokemonByName(name).execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null ? response.errorBody().string() : "Unknown error");
        }
        return response.body();
    }

    @Override
    public EvolutionChainResponse getEvolutionChain(String idEvolutionChain) throws IOException {
        Response<EvolutionChainResponse> response = pokeApi.getEvolutionChain(idEvolutionChain).execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null ? response.errorBody().string() : "Unknown error");
        }
        return response.body();
    }

    @Override
    public PokemonSpecieResponse getSpecieByPokemonId(String pokemonId) throws IOException {
        Response<PokemonSpecieResponse> response = pokeApi.getPokemonSpecieByPokemonId(pokemonId).execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null ? response.errorBody().string() : "Unknown error");
        }
        return response.body();
    }
}
