package com.example.pokemonapi.service;

import com.example.pokemonapi.model.api.Pokemon;
import com.example.pokemonapi.model.api.PokemonDetail;

import java.io.IOException;
import java.util.List;

public interface PokemonService {

    List<Pokemon> getPokemonList() throws IOException;
    List<PokemonDetail> getPokemonDetailList() throws IOException;

}
