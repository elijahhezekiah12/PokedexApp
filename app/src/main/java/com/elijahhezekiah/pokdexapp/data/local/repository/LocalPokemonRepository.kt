package com.elijahhezekiah.pokdexapp.data.local.repository

import com.elijahhezekiah.pokdexapp.domain.model.Pokemon

interface LocalPokemonRepository{
    suspend fun favoritePokemon(pokemon: Pokemon)
    suspend fun unFavoritePokemon(pokemon: Pokemon)
    suspend fun getAllFavoritePokemon() : List<Pokemon?>

}