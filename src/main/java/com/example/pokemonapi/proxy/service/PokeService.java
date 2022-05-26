package com.example.pokemonapi.proxy.service;

import com.example.pokemonapi.model.thirdparty.EvolutionChainResponse;
import com.example.pokemonapi.model.thirdparty.PokemonListResponse;
import com.example.pokemonapi.model.thirdparty.PokemonResponse;

import java.io.IOException;

public interface PokeService {
    PokemonListResponse getAllPokemon() throws IOException;
    PokemonResponse getPokemonById(String id) throws IOException;
    PokemonResponse getPokemonByName(String name) throws IOException;
    EvolutionChainResponse getEvolutionChain(String pokemonId) throws IOException;

}
