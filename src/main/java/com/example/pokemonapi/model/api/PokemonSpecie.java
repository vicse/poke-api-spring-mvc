package com.example.pokemonapi.model.api;

import lombok.Data;

@Data
public class PokemonSpecie {
    private EvolutionChain evolution_chain;
    private String name;
}
