package com.example.pokemonapi.model.thirdparty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse {

    private SpritesResponse sprites;

}
