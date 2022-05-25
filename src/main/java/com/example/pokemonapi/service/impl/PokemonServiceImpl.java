package com.example.pokemonapi.service.impl;

import com.example.pokemonapi.model.api.Pokemon;
import com.example.pokemonapi.model.api.PokemonDetail;
import com.example.pokemonapi.model.thirdparty.PokemonResponse;
import com.example.pokemonapi.proxy.service.PokeService;
import com.example.pokemonapi.service.PokemonService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {

    @Value("${http-client.pokeapi.base-url}")
    private String pokeApiBaseUrl;

    private final PokeService pokeService;

    @Override
    public List<Pokemon> getPokemonList() throws IOException {

        return pokeService.getAllPokemon().getResults()
            .stream().map(result -> new Pokemon(result.getName(), result.getUrl()))
            .collect(Collectors.toList());
    }

    @Override
    public List<PokemonDetail> getPokemonDetailList() throws IOException {
        List<Pokemon> pokemonList = pokeService.getAllPokemon().getResults()
                .stream().map(result -> new Pokemon(result.getName(), result.getUrl()))
                .collect(Collectors.toList());

        List<PokemonDetail> pokemonDetailList = new ArrayList<>();

        for (Pokemon pokemon : pokemonList) {
            String urlImage = getPokemonDetail(pokemon).getSprites().getFront_default();
            PokemonDetail pokemonDetail = new PokemonDetail(pokemon.getName(), urlImage);
            pokemonDetailList.add(pokemonDetail);
        }

        return pokemonDetailList;

    }

    private PokemonResponse getPokemonDetail(Pokemon pokemon) throws IOException {
        return pokeService.getPokemonById(getIdPokemon(pokemon));
    }

    private String getIdPokemon(Pokemon pokemon) {
        String urlWithOutBaseUrl = pokemon.getUrlDetail().replaceAll(pokeApiBaseUrl, "");
        return urlWithOutBaseUrl.replaceAll("[^0-9]","");
    }

}
