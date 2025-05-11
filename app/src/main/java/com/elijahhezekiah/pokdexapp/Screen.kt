package com.elijahhezekiah.pokdexapp

import kotlinx.serialization.Serializable


@Serializable
data class PokemonRoute(val name: String, val url: String)




// Navigation routes for screens
sealed class Route  {
    @Serializable
    data object PokemonListRoute : Route()
    @Serializable
    data object FavoriteRoute :Route()
}