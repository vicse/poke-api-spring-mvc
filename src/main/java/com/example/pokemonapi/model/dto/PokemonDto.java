package com.example.pokemonapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PokemonDto {

    private String name;
    private String urlImage;
}
