package com.example.pokemonapi.model.thirdparty;

import java.util.List;
import lombok.Data;

@Data
public class ChainResponse {
    private List<EvolvesToResponse> evolves_to;
}
