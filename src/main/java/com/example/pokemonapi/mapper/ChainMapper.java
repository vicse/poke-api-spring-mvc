package com.example.pokemonapi.mapper;

import com.example.pokemonapi.model.api.Chain;
import com.example.pokemonapi.model.thirdparty.ChainResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ChainMapper {
    Chain toModel(ChainResponse chainResponse);
}
