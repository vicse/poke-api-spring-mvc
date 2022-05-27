package com.example.pokemonapi.model.thirdparty;

import java.util.List;
import lombok.Data;

@Data
public class EvolutionChainListResponse {
    private List<ResultResponse> results;
}
