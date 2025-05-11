package com.elijahhezekiah.pokdexapp.data

import com.elijahhezekiah.pokdexapp.data.model.dto.PokemanDto
import com.elijahhezekiah.pokdexapp.data.model.dto.PokemonData
import com.elijahhezekiah.pokdexapp.data.model.dto.Result
import com.elijahhezekiah.pokdexapp.data.model.dto.Stat
import com.elijahhezekiah.pokdexapp.data.model.dto.Type
import com.elijahhezekiah.pokdexapp.data.model.dto.TypeX
import com.elijahhezekiah.pokdexapp.domain.repository.PokemonRepository

class FakePokemonRepository : PokemonRepository {

    private val pokemonsResult = mutableListOf<Result>(
        Result(name = "Bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"),
        Result(name = "Charmander", url = "https://pokeapi.co/api/v2/pokemon/4/"),
        Result(name = "Squirtle", url = "https://pokeapi.co/api/v2/pokemon/7/"),
    )

    private val stats : List<Stat> = listOf()

    private val pokemon =
        PokemanDto(
            id = 1,
            name = "Bulbasaur",
            height = 7,
            weight = 69,
            types = listOf(Type(slot = 1, type = TypeX(name = "Grass", url = ""))),
            abilities = null,
            base_experience = null,
            cries = null,
            forms = null,
            game_indices = null,
            held_items = null,
            is_default = true,
            location_area_encounters = "",
            moves = null,
            order = 1,
            past_abilities = null,
            past_types = null,
            species = null,
            sprites = null,
            stats = stats
        )






    override suspend fun getPokemonList(): PokemonData {
        return PokemonData(pokemonsResult)
    }

    override suspend fun getPokemonInfo(name: String): PokemanDto {
         return pokemon
    }


}