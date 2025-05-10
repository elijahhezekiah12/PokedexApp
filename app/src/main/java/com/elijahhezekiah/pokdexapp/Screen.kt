package com.elijahhezekiah.pokdexapp

import kotlinx.serialization.Serializable


@Serializable
data class PokemonRoute(val name: String)

@Serializable
data object PokemonListRoute