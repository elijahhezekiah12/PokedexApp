package com.elijahhezekiah.pokdexapp.data.model.Mappers

import com.elijahhezekiah.pokdexapp.data.model.dto.PokemanDto
import com.elijahhezekiah.pokdexapp.data.model.dto.PokemonData
import com.elijahhezekiah.pokdexapp.domain.model.Pokemon
import com.elijahhezekiah.pokdexapp.domain.model.PokemonDetails

fun PokemanDto.toPokemonDetails(): PokemonDetails {
    return PokemonDetails(
        name = name,
        sprites = sprites,
        height = height,
        weight = weight,
        stats = stats
    )
}


fun PokemonData. toPokemon(): List<Pokemon>{
    val pokemonList = mutableListOf<Pokemon>()
    pokemonList.addAll(results.map {
        Pokemon(
            name = it.name,
            url = it.url
        )
    })
    return pokemonList
}