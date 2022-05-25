package com.example.pokemonapi.controller;

import com.example.pokemonapi.model.dto.PokemonDto;
import com.example.pokemonapi.service.PokemonService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/all")
    public List<PokemonDto> getAllPokemon() throws IOException {
        return pokemonService.getPokemonList().stream()
                .map(p -> new PokemonDto(p.getName(), p.getUrlDetail() != null ? p.getUrlDetail() : null))
                .collect(Collectors.toList());
    }

    @GetMapping("/all/detail")
    public List<PokemonDto> getAllPokemonDetail() throws IOException {
        return pokemonService.getPokemonDetailList().stream()
                .map(p -> new PokemonDto(p.getName(), p.getImgUrl() != null ? p.getImgUrl() : null))
                .collect(Collectors.toList());
    }

}
