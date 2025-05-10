package com.elijahhezekiah.pokdexapp.data.local.repository

import com.elijahhezekiah.pokdexapp.data.local.FavoritePokemonDao
import com.elijahhezekiah.pokdexapp.domain.model.Pokemon
import javax.inject.Inject

class LocalPokemonRepositoryImpl@Inject constructor(
    private val dao: FavoritePokemonDao
) : LocalPokemonRepository {

    override suspend fun favoritePokemon(pokemon: Pokemon) {
        return dao.insert(pokemon)
    }

    override suspend fun unFavoritePokemon(pokemon: Pokemon) {
        return dao.deletePokemonByName(pokemon.name)
    }

    override suspend fun getAllFavoritePokemon(): List<Pokemon?> {
        return dao.getAllPokemon()
    }

}