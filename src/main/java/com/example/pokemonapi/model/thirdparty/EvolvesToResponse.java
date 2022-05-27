package com.example.pokemonapi.model.thirdparty;

import java.util.List;
import lombok.Data;

@Data
public class EvolvesToResponse {
    private SpecieResponse species;
    private List<EvolvesToResponse> evolves_to;
}
