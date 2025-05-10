package com.elijahhezekiah.pokdexapp.data.remote.repository

import android.util.Log
import com.elijahhezekiah.pokdexapp.data.model.dto.PokemanDto
import com.elijahhezekiah.pokdexapp.data.model.dto.PokemonData
import com.elijahhezekiah.pokdexapp.data.remote.PokeApi
import com.elijahhezekiah.pokdexapp.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokeApi
): PokemonRepository {
    override suspend fun getPokemonList(): PokemonData {
        Log.d("PokemonRepositoryImpl", "getPokemonList() called")
        return api.getPokemonList()
    }

    override suspend fun getPokemonInfo(name: String): PokemanDto {

        return api.getPokemonInfo(name)

    }
}