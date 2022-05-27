package com.example.pokemonapi.model.thirdparty;

import lombok.Data;

@Data
public class PokemonSpecieResponse {
    private EvoluteChainResponse evolution_chain;
    private String name;
}
