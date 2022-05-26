package com.example.pokemonapi.model.thirdparty;

import lombok.Data;

@Data
public class SpritesResponse {
    private String back_default;
    private String back_shiny;
    private String front_default;
    private String front_shiny;
    private OtherResponse other;
}
