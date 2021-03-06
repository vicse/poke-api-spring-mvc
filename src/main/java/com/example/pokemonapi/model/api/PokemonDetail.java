package com.example.pokemonapi.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PokemonDetail {
    private String name;
    private String imgUrl;
}
