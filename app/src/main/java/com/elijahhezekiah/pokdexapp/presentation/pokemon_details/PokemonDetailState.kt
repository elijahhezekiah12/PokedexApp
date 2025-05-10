package com.elijahhezekiah.pokdexapp.presentation.pokemon_details

import com.elijahhezekiah.pokdexapp.domain.model.PokemonDetails

data class PokemonDetailState (
    val isLoading : Boolean = false,
    val error : String = "",
    val pokemon : PokemonDetails? = null
)