package com.elijahhezekiah.pokdexapp.presentation.pokemon_list

import com.elijahhezekiah.pokdexapp.domain.model.Pokemon

data class PokemonListState(
    val isLoading: Boolean = false,
    val error: String = "",
    var pokemonList: List<Pokemon> = emptyList(),
)