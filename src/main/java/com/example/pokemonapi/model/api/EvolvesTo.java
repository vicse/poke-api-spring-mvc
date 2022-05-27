package com.example.pokemonapi.model.api;

import java.util.List;
import lombok.Data;

@Data
public class EvolvesTo {
    private List<EvolvesTo> evolves_to;
    private Specie species;
}
