package com.example.pokemonapi.model.thirdparty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpritesResponse {

    private String back_default;
    private String back_shiny;
    private String front_default;
    private String front_shiny;
}
