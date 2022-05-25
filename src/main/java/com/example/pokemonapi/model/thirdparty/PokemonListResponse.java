package com.example.pokemonapi.model.thirdparty;

import java.util.List;
import lombok.Data;

@Data
public class PokemonListResponse {
    private Integer count;
    private String next;
    private String previous;
    private List<ResultResponse> results;
}
