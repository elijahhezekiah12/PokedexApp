package com.elijahhezekiah.pokdexapp.presentation.FavoriteView

import com.elijahhezekiah.pokdexapp.domain.model.Pokemon

data class FavoritePokemonListState(

    var pokemonList: List<Pokemon?> = emptyList(),
)