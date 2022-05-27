package com.example.pokemonapi.model.api;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class Chain {
    private Specie species;
    private List<EvolvesTo> evolves_to;
}
