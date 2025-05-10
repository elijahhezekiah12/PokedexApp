package com.elijahhezekiah.pokdexapp.domain.repository

import com.elijahhezekiah.pokdexapp.data.model.dto.PokemanDto
import com.elijahhezekiah.pokdexapp.data.model.dto.PokemonData
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonRepository {
    @GET("api/v2/pokemon")
    suspend fun  getPokemonList(): PokemonData

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonInfo(@Path("name") name: String): PokemanDto
}