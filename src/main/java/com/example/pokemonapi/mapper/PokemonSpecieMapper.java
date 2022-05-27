package com.example.pokemonapi.mapper;

import com.example.pokemonapi.model.api.PokemonSpecie;
import com.example.pokemonapi.model.thirdparty.PokemonSpecieResponse;
import org.mapstruct.Mapper;

@Mapper
public interface PokemonSpecieMapper {
    PokemonSpecie toModel(PokemonSpecieResponse pokemonSpecieResponse);
}
