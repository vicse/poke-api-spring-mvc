package com.example.pokemonapi.controller;

import com.example.pokemonapi.mapper.PokemonMapper;
import com.example.pokemonapi.model.api.PokemonDetail;
import com.example.pokemonapi.model.dto.PokemonDetailDto;
import com.example.pokemonapi.model.dto.PokemonDto;
import com.example.pokemonapi.service.PokemonService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PokemonController {

    private final PokemonService pokemonService;

    PokemonMapper mapper = Mappers.getMapper(PokemonMapper.class);

    @GetMapping("/all")
    public List<PokemonDto> getAllPokemon() throws IOException {
        return pokemonService.getPokemonList()
            .stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/all/detail")
    public List<PokemonDetailDto> getAllPokemonDetail() throws IOException {
        return pokemonService.getPokemonDetailList()
            .stream()
            .map(mapper::pokemonDetailToDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/evolution/{pokemonId}")
    public PokemonDetailDto getEvolutionByPokeId(@PathVariable("pokemonId") String pokemonId) throws IOException {
        PokemonDetail pokemonDetail = pokemonService.getEvolutionByPokeId(pokemonId);
        return mapper.pokemonDetailToDto(pokemonDetail);
    }

    @GetMapping("/evolution/list/{pokemonId}")
    public List<PokemonDetailDto> getEvolutionListByPokeId(@PathVariable("pokemonId") String pokemonId) throws IOException {
        return pokemonService.getEvolutionListByPokeId(pokemonId)
            .stream()
            .map(mapper::pokemonDetailToDto)
            .collect(Collectors.toList());
    }

}
