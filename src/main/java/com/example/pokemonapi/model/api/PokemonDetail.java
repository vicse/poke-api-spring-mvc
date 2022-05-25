package com.example.pokemonapi.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonDetail {
    private String name;
    private String imgUrl;
}
