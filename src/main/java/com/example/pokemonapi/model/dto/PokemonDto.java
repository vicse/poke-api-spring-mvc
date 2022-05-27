package com.example.pokemonapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonDto {
    private String name;
    private String urlDetail;
}
