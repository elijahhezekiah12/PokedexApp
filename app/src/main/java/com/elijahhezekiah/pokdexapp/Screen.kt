package com.elijahhezekiah.pokdexapp

import kotlinx.serialization.Serializable


@Serializable
data class PokemonRoute(val name: String, val url: String)

@Serializable
data object PokemonListRoute