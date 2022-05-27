package com.example.pokemonapi.mapper;

import com.example.pokemonapi.model.api.Pokemon;
import com.example.pokemonapi.model.api.PokemonDetail;
import com.example.pokemonapi.model.dto.PokemonDetailDto;
import com.example.pokemonapi.model.dto.PokemonDto;
import org.mapstruct.Mapper;

@Mapper
public interface PokemonMapper {
    PokemonDetailDto pokemonDetailToDto(PokemonDetail pokemonDetail);
    PokemonDto toDto(Pokemon pokemon);
}
